package com.isea.virgin.scala.tuple

object TupleDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 创建一个元组tuple 类是 tuple4，tuple的类型取决于tuple的个数
      * 元组最多有22个元素，Tuple1 --> Tuple22
      * 获取元组的元素的方法 tuple._1表示获取元组中的第一个元素
      */
    val tuple1 = (1,2,3,"isea")
    println(tuple1) // (1,2,3,isea)
    println(tuple1._1 + " " + tuple1._2) // 1 2

    // 访问元组的第二种方式：productElement ，这里是按照索引来取元素的
    println("①：" + tuple1.productElement(0) + " ②：" + tuple1.productElement(3))

    // 元素的遍历
    for (elem <- tuple1.productIterator) {
      print(elem + " ") //1 2 3 isea
    }
  }
}


