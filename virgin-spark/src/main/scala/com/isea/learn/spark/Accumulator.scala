package com.isea.learn.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author isea_you
  * @date 2019/9/3
  * @time 20:15
  * @target:
  */
object Accumulator {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("learn Accumulator").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rdd: RDD[Int] = sc.makeRDD(Array(1,2,3,4,5))
    val sum = sc.longAccumulator("sum")
    rdd.map( item =>{
      sum.add(item)
    }).collect
    println(sum)  // LongAccumulator(id: 0, name: Some(sum), value: 15)
  }
}
