package com.isea.virgin.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author isea_you
  * @date 2019/10/16
  * @time 20:23
  * @target:
  */
object SparkPartition {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[4]").setAppName("RDD's 的分区 ")
    val sc = new SparkContext(conf)
    val rdd: RDD[Int] = sc.makeRDD(Array(1,2,3,4))
    println(rdd.partitions.length)// 4
  }
}
