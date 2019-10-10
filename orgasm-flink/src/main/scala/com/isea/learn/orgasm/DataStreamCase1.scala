package com.isea.learn.orgasm

import java.util.Calendar

import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.functions.source.{RichParallelSourceFunction, SourceFunction}
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

import scala.collection.immutable
import scala.util.Random


/**
  * @author isea_you
  * @date 2019/9/29
  * @time 13:29
  * @target:
  */
object DataStreamCase1 {
  def main(args: Array[String]): Unit = {
    // 获取执行环境
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    // 设置流的时间为Event time
    // env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
    // 设置并行度为1，如果不设置，默认为当前机器的CPU的数量
    env.setParallelism(1);

    import org.apache.flink.streaming.api.scala._
    /*env.addSource(new SensorSource)
      .map(r => r.id)
      print()
    */

    /*env
      .fromElements((1,2),(2,2),(1,4),(2,3))
        .keyBy(0)
        .sum(1)
        .print()
    */
    env.fromElements(("en", List("tea")), ("fr", List("vin")), ("en", List("cake")))
        .keyBy(0)
        .reduce((x,y) => (x._1,x._2:::y._2))


    env.execute("define a data source...")
  }
}


// 传感器id，时间戳，温度
case class SensorReading(id: String, timestamp: Long, temperature: Double)

// 需要extends RichParallelSourceFunction, 泛型为SensorReading
class SensorSource extends RichParallelSourceFunction[SensorReading] {
  // 表示数据源是否还在正常运行
  var running: Boolean = true

  // run()函数连续的发送SensorReading数据，使用SourceContext // 需要override
  override def run(srcCtx: SourceFunction.SourceContext[SensorReading]): Unit = {
    // 初始化随机数发生器
    val rand = new Random()

    // 查找当前运行时上下文的任务的索引
    //      val taskIdx = this.getRuntimeContext.getIndexOfThisSubtask

    // 初始化10个(温度传感器的id, 温度值)元组
    var curFTemp: immutable.IndexedSeq[(String, Double)] = (1 to 10).map {
      // nextGaussian产生高斯随机数
      //        i => ("sensor_" + (taskIdx * 10 + i), 65 + (rand.nextGaussian() * 20))
      i => ("sensor_" + i, 65 + (rand.nextGaussian() * 20))
    }
    // 无限循环，产生数据流
    while (running) {
      // 更新温度
      curFTemp = curFTemp.map(t => (t._1, t._2 + (rand.nextGaussian() * 0.5)))
      // 获取当前时间戳
      val curTime = Calendar.getInstance.getTimeInMillis
      // 发射新的传感器数据, 注意这里srcCtx.collect
      curFTemp.foreach(t => srcCtx.collect(SensorReading(t._1, curTime, t._2)))
      // wait for 100 ms
      Thread.sleep(100)
    }
  }

  override def cancel(): Unit = {}

}

