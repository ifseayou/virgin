package com.isea.virgin.scala.closure_demo

object Closure_Demo1 {
  def main(args: Array[String]): Unit = {
    var x = 10

    /*
      condition:()=> Boolean 函数 和 block : () => Unit 函数
     */
    def until(condition: => Boolean)(block: => Unit): Unit = {
      if (!condition) {
        block
        until(condition)(block)
      }
    }
    /*
      until(()=>x == 0)(() => {x-=1;print(x+" ")})
     */
    until(x == 0) {
      x -= 1
      print(x + " ")
    }
  } // 9 8 7 6 5 4 3 2 1 0
}
