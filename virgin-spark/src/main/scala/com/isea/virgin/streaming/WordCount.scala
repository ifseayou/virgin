package com.isea.virgin.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @author isea_you
  * @date 2019/10/12
  * @time 21:33
  * @target:
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[4]").setMaster("spark streaming word count")
    val ssc = new StreamingContext(conf,Seconds(3))
    val dStream: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop110",9999)

    val wc: DStream[(String, Int)] = dStream.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _)

    // 打印结果
    wc.print()

    // 启动接收器
    ssc.start()

    // main 线程等待，接收器的执行
    ssc.awaitTermination()
  }

}
