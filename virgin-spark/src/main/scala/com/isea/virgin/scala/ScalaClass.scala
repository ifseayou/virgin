package com.isea.virgin.scala

object ScalaClass {
  def main(args: Array[String]): Unit = {
    val outer1 = new ScalaOuterClass
    val outer2 = new ScalaOuterClass

    val innter1 = new outer1.ScalaInnerClass
    val intter2 = new outer2.ScalaInnerClass

    innter1.test(innter1)
    innter1.test(intter2) // 没有类型投影之前，需要innter1.ScalaOuterClass; 有了类型投影之后，需要ScalaOuterClass类型
    /**
      * com.isea.scala.ScalaOuterClass$ScalaInnerClass@47f37ef1
      * com.isea.scala.ScalaOuterClass$ScalaInnerClass@5a01ccaa
      */
  }
}
class ScalaOuterClass{ // 类对象

  myOuter => //  这样写，可以理解为myOuter 就是代表外部类的一个对象
  class ScalaInnerClass{ // 成员内部类
    def test(ic : ScalaOuterClass#ScalaInnerClass): Unit ={
      println(ic)  //ScalaOuterClass#ScalaInnerClass 类型投影
    }
  }
}



