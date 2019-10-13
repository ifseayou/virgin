package com.isea.virgin.scala.array_demo

import scala.collection.mutable.ArrayBuffer
object ArrayDemo01 {
  def main(args: Array[String]): Unit = {

    // 创建了ArrayBuffer 可变数组
    val array = ArrayBuffer("1","2","3")

    // 引入了我们需要的隐式函数，传入的类型是Buffer，目标类型是List
    // implicit def bufferAsJavaList[A](b: mutable.Buffer[A]): ju.List[A] = b match
    import scala.collection.JavaConversions.bufferAsJavaList

    // 这里ProcessBuilder的构造函数需要传入的参数是Java的List，这里array是ArrayBuffer类型，
    // 所以这里使用到了隐式转换,但是这里返回的是command
    val javaArr = new ProcessBuilder(array)

    val arrList = javaArr.command()
    println(arrList)  //[1, 2, 3]

    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable

    // java.util.List => Buffer ; String这里的类型要和原来保持一致
    val scalaArray : mutable.Buffer[String] = arrList
    println(scalaArray) // ArrayBuffer(1, 2, 3)
  }
}



