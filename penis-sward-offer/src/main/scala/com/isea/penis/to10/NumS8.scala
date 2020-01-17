package com.isea.penis.to10

import scala.collection.mutable

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/17 14:25
  * @target: 走台阶问题，一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（
  *         本质是斐波那契数列，这里使用优化过的解法
  */
object NumS8 {
  private val cache = new mutable.HashMap[Int,Int]()
  def JumpFloor(target:Int):Int = {
    if (target == 1) return 1
    else if(target == 2) return 2
    if (cache.contains(target)) cache.get(target)
    val res = JumpFloor(target - 1) + JumpFloor(target -2)
    cache.put(target,res)
    return res
  }
}
