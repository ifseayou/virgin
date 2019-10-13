package com.isea.virgin.scala.high_order

object HighOrderDef {
  def main(args: Array[String]): Unit = {

    /*
      这里方法返回一个函数，在这函数中需要使用到传入到该方法的参数，这就是闭包。我们在学习面向对象的时候，
      传入的参数像是一个属性，而闭包像是一个方法，在这个方法中可以使用该属性。且只要x不销毁，闭包可以一直使用x
     */
    def minusxy(x : Int) = (y : Int) => x - y
    println(minusxy(10)(5)) // 5
  }
}
