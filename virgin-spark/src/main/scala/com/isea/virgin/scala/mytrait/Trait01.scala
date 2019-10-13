package com.isea.virgin.scala.mytrait

object Trait01 {
  def main(args: Array[String]): Unit = {

  }
}

trait Logger{
  // 明确告诉编译器，我就是Exception，如果没有这句代码，下面的getMessage()是不能调用的
  this :Exception =>  // 这句话的作用是：如果一个类想要混入LoggerException特质，要求该类是Exception的子类
  def log: Unit ={
    // 既然我就是Exception，我就可以调用其中的方法
    println(getMessage)
  }
}

/*
class Console extends Logger{ // 报错的原因是 Console 不是 Exception的子类

}
*/

class Console extends Exception with Logger{  // 由于Console是Exception的子类，所以能够混入Logger特质

}

