package com.isea.penis.to20

import scala.collection.mutable.ArrayBuffer

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/24 10:00
  * @target: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
  *          所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
  *
  */
object NumS13 {
  def reOrderArray = (arr:Array[Int]) => {
    val arr1 = new ArrayBuffer[Int]()
    val arr2 = new ArrayBuffer[Int]()

    for (elem <- arr) {
      if (elem % 2 == 1) arr1.append(elem)
      else arr2.append(elem)
    }
    arr1.appendAll(arr2)
    arr1.toArray
  }
}
