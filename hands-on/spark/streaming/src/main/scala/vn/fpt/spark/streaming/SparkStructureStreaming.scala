package vn.fpt.spark.streaming

import org.apache.spark.sql.streaming.StreamingQuery
import org.apache.spark.sql.{Dataset, SparkSession}
import redis.clients.jedis.Jedis
import org.apache.log4j.Logger
import org.apache.log4j.Level

object SparkStructureStreaming {
  val topic = "big-data"

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession
      .builder
      .appName("sparkConsumer")
      .master("local[2]")
      .getOrCreate()
    val dataFrame = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("subscribe", "big-data")
      .load()
    dataFrame.printSchema()
    import spark.implicits._
    val dataSet: Dataset[UserAccess] = dataFrame.selectExpr("CAST(value AS STRING)")
      .as[String]
      .mapPartitions(
        iter => {
          val arr = iter.toArray
          val access = arr.map(x => ApacheAccess(x)).filter(x => x.isDefined).map(_.get)
          val jedis = new Jedis("118.68.170.148", 6379, 1000)
          val userData = access.map(x => {
            val user = jedis.get(x.ip)
            if (user == null)
              UserAccess("", x.ip, x.date, x.method, x.request)
            else
              UserAccess(user, x.ip, x.date, x.method, x.request)
          })
          jedis.quit()
          userData.toIterator
        }
      )
    val query: StreamingQuery = dataSet
      .writeStream
      .outputMode("append")
      .format("csv")
      .option("path", args(0))
      .option("checkpointLocation", args(1))
      .start()
    query.awaitTermination()
  }
}
