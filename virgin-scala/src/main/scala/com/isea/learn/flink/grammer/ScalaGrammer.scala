package com.isea.learn.flink.grammer

import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer


/**
  * @author isea_you
  * @date 2019/8/28
  * @time 11:43
  * @target:
  */
object ScalaGrammer {

}


object Hello{
  def main(args: Array[String]): Unit = {
    println("hello scala....")
    val res: immutable.IndexedSeq[Int] = (1 to 5).map(i => 2 * i)
    println(res)
  }
}

object HelloAPP extends App{
  println("hello , app")
}