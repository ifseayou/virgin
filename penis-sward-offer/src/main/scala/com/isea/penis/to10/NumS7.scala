package com.isea.penis.to10

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/15 21:05
  * @target: 斐波那契数列
  */
object NumS7 {
  def fibonacci(n:Int) : Int = {
    if (n == 1 || n == 2) return 1
    return fibonacci(n - 1) + fibonacci(n - 2)
  }
}
