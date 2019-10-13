package com.isea.virgin.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author isea_you
  * @date 2019/10/11
  * @time 21:10
  * @target:  统计出每一个省份广告被点击次数的TOP3
  */
object AdsTop3 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("get Ads top3")
    val sc = new SparkContext(conf)

    // 读取数据
    val lines: RDD[String] = sc.textFile("dataSource/spark/agent.log")

    /*
      数据格式：时间戳，      省份，城市，用户，广告
      数据实例：1516609143867 6     7     64    16
    */

    // 分解数据为((P,A),1)的形式
    val PAC: RDD[((String, String), Int)] = lines.map(lines => {
      val fields: Array[String] = lines.split(" ")
      val p: String = fields(1)
      val a: String = fields(4)
      ((p, a), 1)
    }) //

    // 统计省份中的广告中的点击次数（（P,A），sum）
    val PAS: RDD[((String, String), Int)] = PAC.reduceByKey(_ +_)

    // 将统计结果进行转换（P ,(A , sum)）,为了方便按照P省份，进行分组，和方便排序
    val PAS2: RDD[(String, (String, Int))] = PAS.map(t => (t._1._1,(t._1._2,t._2)))

    // 将同一个省份中的所有广告分组（P ，[(A1,count),(A2,count)]）
    val pGroup: RDD[(String, Iterable[(String, Int)])] = PAS2.groupByKey()

    // 对同一个省份中的广告点击次数排序，取前三个
    val top3: RDD[(String, List[(String, Int)])] = pGroup.mapValues(t => {
      t.toList.sortWith((t1, t2) => t1._2 > t2._2).take(3)
    })

    // 获取结果
    val res: Array[(String, List[(String, Int)])] = top3.collect()
    res.foreach(t =>{
      t._2.map(t1 =>{
        println(t._1 + "-" + t1._1 + "-" + t1._2)
      })
    })
    sc.stop()
  }
}
