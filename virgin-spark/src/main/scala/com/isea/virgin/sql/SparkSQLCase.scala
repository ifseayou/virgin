package com.isea.virgin.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

/**
  * @author isea_you
  * @date 2019/10/12
  * @time 21:03
  * @target:
  */
object SparkSQLCase {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("SparkSQLCase").setMaster("local[4]")
    // 获得sparkSQL上下文的执行环境
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    val dataFrame: DataFrame = spark.read.json("dataSource/spark/user.json")

    // 增加隐式转化 这个的spark不是包名
    import spark.implicits._

    val dataSet: Dataset[User] = dataFrame.as[User]

    dataSet.show()

    /**
      * +---+--------+
      * |age|    name|
      * +---+--------+
      * | 20|zhangfei|
      * | 30|  guanyu|
      * | 40|  liubei|
      * +---+--------+
      */
    spark.stop()
  }
}

case class User(name:String,age:Long)
