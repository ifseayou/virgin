package com.isea.virgin.scala.list

object ListDemo {
  def main(args: Array[String]): Unit = {

    val list1 = List(1,2,3,"isea")

    val list2 = 4 :: 5 :: 6 :: list1 :: Nil
    println("list2 = " + list2) //list2 = List(4, 5, 6, List(1, 2, 3, isea))

    val list3 = 4 :: 5 :: 6 :: list1
    println("list3 = " + list3) // list3 = List(4, 5, 6, 1, 2, 3, isea)

    // 将集合中的每一个元素追击到空集合中去
    val list4 = 4 :: 5 :: 6 :: list1 ::: Nil
    println("list4 = " + list4) // list4 = List(4, 5, 6, 1, 2, 3, isea)

//    val list5 = 4 :: 5 :: 6 :: list1 ::: Nil :: 5 // 错误写法，应该是将数据放置到集合中
  }
}


