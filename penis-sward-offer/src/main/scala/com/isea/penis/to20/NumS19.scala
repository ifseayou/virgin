package com.isea.penis.to20

import scala.collection.mutable.ArrayBuffer

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/27 11:53
  * @target: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
  *      1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
  *      !!! 注意这里处理的技巧是，每次处理 n- 1个数据 ，如此一来就能很好的控制下标
  */
object NumS19 {

  def circlePrint(matrix: Array[Array[Int]], res: ArrayBuffer[Int], a: Int, b: Int, c: Int, d: Int) = {
    if(a == c) for(i <- c to d) res.append(matrix(a)(i))
    else if(b == d) for(i <- a to c) res.append(matrix(i)(b))
    else{
      var curR = a
      var curC = b
      while (curC != d) {
        res.append(matrix(a)(curC))
        curC += 1
      }
      while (curR != c){
        res.append(matrix(curR)(d))
        curR += 1
      }
      while (curC != b){
        res.append(matrix(c)(curC))
        curR -= 1
      }
      while (curR != a){
        res.append(matrix(curR)(b))
        curC -= 1
      }
    }
  }

  def printMatrix(matrix:Array[Array[Int]]):ArrayBuffer[Int] ={
    val res = new ArrayBuffer[Int]()
    if (matrix!= null && matrix.length > 0){
      var a = 0
      var b = 0
      var c = matrix.length - 1
      var d = matrix(0).length - 1
      while (a <= c && b <= d){
        circlePrint(matrix,res,a,b,c,d)
        a += 1
        b += 1
        c -= 1
        d -= 1
      }
    }
    res
  }
}
