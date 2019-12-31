# Spark Streaming and Spark Structure Streaming 

## Clone running and build package

### Build package
- Tạo file jar

```
sbt package
sbt assemblyPackageDependency
```
- Copy lên jar file lên server


### Run Spark Streaming
- Chỉnh sửa kafka broker và topic nhận log: 118.68.170.148:6667 big-data
- Chỉnh sửa master nếu muốn submit lên yarn
- Chỉnh sửa path output 

- Submit Job example:
``` 
spark-submit --master yarn --class vn.fpt.spark.streaming.StreamingKafka --name baoth5-spark-streaming --deploy-mode cluster --executor-memory 1G --executor-cores 1 --num-executors 1 --jars spark-streaming_2.11-0.0.1.jar spark-streaming-assembly-0.0.1-deps.jar baoth5 /user/member1/baoth5/streaming

```

### Running Spark Structure Streaming 

```
spark-submit --master yarn --class vn.fpt.spark.streaming.SparkStructureStreaming --name baoth5-spark-structure-streaming --deploy-mode cluster --executor-memory 1G --executor-cores 1 --num-executors 1 --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.3.1 --jars spark-streaming_2.11-0.0.1.jar spark-streaming-assembly-0.0.1-deps.jar  /user/member1/baoth5/streaming-structure /user/member1/baoth5/checkpoint
```

## Exercise

- Trong project của anh/chị đang chạy hiện tại có một số lỗi thường gặp trong việc viết job spark làm cho job bị treo và chết sau một thời gian chạy. Anh/chị hãy tìm các lỗi đó và fix nó. 

- Trong project trên cũng có một số chỗ chưa được optimise, anh/chị có thể tìm ra nó không? 
