package com.isea.penis.to20

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/24 8:39
  * @target:
  */
object NumS11 {
  val NumberOf1 = (n:Int)=>{
    var count = 0
    var target = n
    while (target != 0){
      count +=1
      target = target & (target - 1)
    }
    count
  }

  def main(args: Array[String]): Unit = {
    println(NumberOf1(2))
  }
}
