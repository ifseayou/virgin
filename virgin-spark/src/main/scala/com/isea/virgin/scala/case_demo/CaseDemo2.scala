package com.isea.virgin.scala.case_demo

object CaseDemo2 {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)
    // 正常的写法：直接给map传入一个匿名函数
    println(list.map((x: Int) => x + 1)) // List(2, 3, 4, 5, 6)

    // 简写，因为编译器可以推断出List元素是Int类型，因此Int可以省略
    println(list.map((x) => x + 1)) // List(2, 3, 4, 5, 6)

    // 因为匿名函数的形参只有一个参数，因此省略小括号
    println(list.map(x => x + 1)) // List(2, 3, 4, 5, 6)

    // 因为x在=> 的右边只出现了一次，所以用_ 替代，同时将 x => 去掉
    println(list.map( _ + 1)) // List(2, 3, 4, 5, 6)

    // 使用简化，来完成对于List的求和
    println("list的和 = " + list.reduceLeft(_+_)) // list的和 = 15

  }
}
