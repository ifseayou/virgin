package com.isea.virgin.scala.grammer

/**
  * @author isea_you
  * @date 2019/10/12
  * @time 21:30
  * @target:
  */
object CurringCase {
  def main(args: Array[String]): Unit = {
    println(mul(2)(3))
  }
  def mul(x:Int)(y:Int) = x * y
}
