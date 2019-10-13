package com.isea.virgin.scala.map

import scala.collection.mutable
object ScalaMap {
  def main(args: Array[String]): Unit = {
    // 构建可变的map mutable,无序的Map ,可变的需要带包名了
    val map1 = mutable.Map("Alice" -> 10,"Bob" -> 20,"Scott" -> 30)
    println("map1 = " + map1) // map1 = Map(Bob -> 20, Alice -> 10, Scott -> 30)

    // 修改isea 的值，因为isea不存在，所以等价于添加了,如果存在，那么就是修改操作（map是有是mutable的，才可以修改，否则报错）
    map1("isea") = 23
    println("map1 = " + map1) // map1 = Map(Bob -> 20, isea -> 23, Alice -> 10, Scott -> 30)

    // 真正的向map中添加元素,如果key存在的话，则会变成修改
    map1 += ("A" -> 33) // 添加单个元素
    println("map1 = " + map1) //map1 = Map(Bob -> 20, A -> 33, isea -> 23, Alice -> 10, Scott -> 30)

    // 向map中添加多个元素
    map1 += ("B" -> 22,"C" -> 99)
    println("map1 = " + map1) //  map1 = Map(Bob -> 20, A -> 33, isea -> 23, C -> 99, Alice -> 10, Scott -> 30, B -> 22)

    // 删除map中的元素,可以删除多个，如果key存在，就删除，如果key不存在，不会报错，默认是什么都不做的
    map1 -= ("A","B")
    println("map1 = " + map1) //  map1 = Map(Bob -> 20, A -> 33, isea -> 23, C -> 99, Alice -> 10, Scott -> 30, B -> 22)



    // 对于map的遍历，对于map中的元素，每次遍历出来，都是元组，取出的时候按照元组的方式来取
    for ((k,v) <- map1) {  // 遍历元组中的key，和val
      print("k="+ k + "v=" + v + "\t")
    }

    for (elem <- map1.keys) { // 只是遍历key
      print(elem + "\t")
    }

    for (elem <- map1.values) { // 只是遍历val
      print(elem + "\t")
    }

    for (elem <- map1) { // 全部遍历元素
      print("item="+ elem)
      print("k=" + elem._1 + ",v="+ elem._2)
    }



  }
}


