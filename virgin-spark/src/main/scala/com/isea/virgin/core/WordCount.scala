package com.isea.virgin.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author isea_you
  * @date 2019/10/12
  * @time 11:19
  * @target:
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("WordCount demo").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val dataSource: RDD[String] = sc.textFile("dataSource/spark/wordcount")
    val res: RDD[(String, Int)] = dataSource.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _)
    res.foreach(println)
  }
}
