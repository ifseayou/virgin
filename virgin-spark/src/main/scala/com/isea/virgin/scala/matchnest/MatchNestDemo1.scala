package com.isea.virgin.scala.matchnest

object MatchNestDemo1 {
  def main(args: Array[String]): Unit = {
    for (item <- Array(Spring,Autumn)){
      item match {
        case Spring => println("春天")
        case Autumn => println("秋天")
        case _ => println("error....")
      }
      /**
        * 春天
        * 秋天
        */
    }
  }
}

// 创建样例类
abstract class Season

case object Spring extends Season
case object Autumn extends Season
