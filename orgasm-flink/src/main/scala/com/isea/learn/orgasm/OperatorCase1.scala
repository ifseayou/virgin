package com.isea.learn.orgasm

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

/**
  * @author isea_you
  * @date 2019/9/29
  * @time 15:14
  * @target:
  */
object OperatorCase1 {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    import org.apache.flink.api.scala._

    // 听到的最好的关于flatMap的解释：可以生成0个或者是1个或者是多个数据，所以最后需要一个集合来收集数据
    List("a_b","c_d").flatMap(t => t.split("_"))

    env.execute("operators...")

  }
}


