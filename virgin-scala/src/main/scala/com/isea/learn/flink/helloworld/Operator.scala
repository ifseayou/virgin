package com.isea.learn.flink.helloworld

import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}

case class SensorRecord(id:String,timeStamp:Long,temperature:Double)
object Operator {
  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    val path = "G:\\scala_learn\\Flink\\Flink-Hello-World\\src\\main\\resources\\sensor.txt"
    val streamDS: DataSet[String] = env.readTextFile(path)
    import org.apache.flink.api.scala._
    val finalDS: AggregateDataSet[SensorRecord] = streamDS.map(data => {
      val values: Array[String] = data.split(",")
      SensorRecord(values(0).trim, values(1).trim.toLong, values(2).trim.toDouble)
    }).groupBy("id")
      .sum("temperature")
    finalDS.print()
  }
}

