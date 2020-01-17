package com.isea.penis.to10

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/17 16:11
  * @target:
  */
object NumS9 {
  def JumpFloorII(target:Int):Int = {
    if (target <= 0) 0
    else if (target == 1) 1
    else 2 * JumpFloorII(target - 1)
  }
}
