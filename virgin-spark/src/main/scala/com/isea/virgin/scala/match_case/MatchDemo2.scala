package com.isea.virgin.scala.match_case

object MatchDemo2 {
  def main(args: Array[String]): Unit = {
    val map = Map("A" -> 0,"B" -> 1,"C" -> 2)
    for ((k,v) <- map)
      print(k + "->" + v + " ") // A->0 B->1 C->2

    for ((k,0) <- map) //  如果v不等于0，就直接过滤了
      print(k + "->" + 0 + " ") //  A->0

    for ((k,v) <- map if v == 0) // if v == 0 是一个过滤的条件
      print(k + "->" + v + " ") // A->0
  }
}
