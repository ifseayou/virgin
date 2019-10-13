/*
package com.isea.scala.homework.bubble

import scala.util.Random

object ScalaBubbleSort extends App {
  val arr = Array(1,7,6,3,5,6)
  val scalaBubbleSort = new ScalaBubbleSort

  // 产生一个随机长度，随机数值的数组
  val arr1 = scalaBubbleSort.genRandomArray(100,100)

  //将该数组拷贝一份
  val arr2 = scalaBubbleSort.copyArray(arr1)

  // 使用绝对正确的排序算法排序，然后在使用自己实现的算法排序



  scalaBubbleSort.printArray(arr)
  scalaBubbleSort.bubbleSort(arr)
  println()
  scalaBubbleSort.printArray(arr)

}

class ScalaBubbleSort{
  /**
    * 冒泡排序
    * @param array
    */
  def bubbleSort(array :Array[Int]): Unit ={
    for (end <- 1 to array.length - 1 reverse) {
      for (i <- 0 until end ){
        if (array(i) > array(i + 1)){
          scalaSwap(array,i,i + 1)
        }
      }
    }
  }

  def scalaSwap(arr : Array[Int],i : Int,j : Int): Unit ={
    val tmp : Int = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }

  def printArray(array : Array[Int]): Unit ={
    for (elem <- array) {
      print(elem + " ")
    }
  }

  def genRandomArray(maxSize : Int,maxValue :Int): Array[Int] ={
    if (maxSize < 0)
      throw new IllegalArgumentException("Illegal param...")
    val array : Array[Int] = new Array[Int](new Random().nextInt(maxSize + 1))
    for(i <- 0 until array.length ){
      array(i) = (new Random().nextInt(maxValue + 1)) - (new Random().nextInt(maxValue + 1))
    }
    array
  }

  def copyArray(array : Array[Int]): Array[Int] ={
    val newArr = new Array[Int](array.length)
    for (i <- 0 to array.length - 1)
      newArr(i) = array(i)
    newArr
  }
}*/
