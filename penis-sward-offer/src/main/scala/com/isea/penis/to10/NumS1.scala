package com.isea.penis.to10


/**
  * @author ifseayou@gmail.com
  * @date 2020/1/6 19:42
  * @target:
  * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
  * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
  */
object NumS1 {
  def find(target: Int, matrix: Array[Array[Int]]): Boolean = {
    var a = 0
    var b = matrix(0).length - 1
    while (a < matrix.length && b >= 0) {
      if (matrix(a)(b) == target) return true
      else if (matrix(a)(b) > target) b -= 1
      else a += 1
    }
    return false
  }

  /**
    * 柯里化写法
    * @param target
    * @param matrix
    * @return
    */
  def find2 (target:Int)(matrix:Array[Array[Int]]):Boolean = {
    var a = 0
    var b = matrix(0).length - 1
    while (a < matrix.length && b >= 0) {
      if (matrix(a)(b) == target) return true
      else if (matrix(a)(b) > target) b -= 1
      else a += 1
    }
    return false
  }
}
