package com.isea.learn.flink.grammer

/**
  * @author isea_you
  * @date 2019/8/28
  * @time 11:40
  * @target:
  */
package object Grammer {
  def abs(x : Double) = if (x >= 0) x else - x
  def main(args: Array[String]): Unit = {
    abs(-3)
  }
}
