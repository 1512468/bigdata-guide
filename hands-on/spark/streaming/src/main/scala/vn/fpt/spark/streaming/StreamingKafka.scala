package vn.fpt.spark.streaming

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import redis.clients.jedis.Jedis

case class UserAccess(name: String, ip: String, date: String, method: String, request: String)

object StreamingKafka {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Streaming Driver")
      .setMaster("local[2]")
    val ssc = new StreamingContext(sparkConf, Seconds(60))
    ssc.sparkContext.setLogLevel("warn")
    val spark = SparkSession.builder().getOrCreate()

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> args(0),
      "auto.offset.reset" -> "earliest",
      "enable.auto.commit" -> (false: java.lang.Boolean))
    val topics = Array("big-data")
    val consumerStrategy = Subscribe[String, String](topics, kafkaParams)
    val stream = KafkaUtils.createDirectStream[String, String](ssc, PreferConsistent, consumerStrategy)
      .transform(extractMessage)
    import spark.implicits._

    stream.foreachRDD(rdd => {
      val userDs = rdd.toDS().map(x => {
        val jedis = new Jedis("118.68.170.148", 6379, 1000)
        val user = jedis.get(x.ip)
        jedis.quit()
        if (user == null)
          UserAccess("", x.ip, x.date, x.method, x.request)
        else
          UserAccess(user, x.ip, x.date, x.method, x.request)

      }).cache()
      userDs.write.mode("append").csv(args(1))
      userDs.show(false)
    })
    ssc.start()
    ssc.awaitTermination()
  }

  def extractMessage = (rdd: RDD[ConsumerRecord[String, String]]) => {
    rdd.map(msg => {
      ApacheAccess(msg.value())
    }).filter(x => x.isDefined).map(_.get)
  }
}
