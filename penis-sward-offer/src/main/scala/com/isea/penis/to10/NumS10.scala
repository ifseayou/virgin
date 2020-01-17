package com.isea.penis.to10

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/17 16:18
  * @target:
  */
object NumS10 {
  def RectCover(target:Int): Int ={
    if (target == 1) 1
    else if (target == 2) 2
    else RectCover(target - 1) + RectCover(target -2)
  }
}
