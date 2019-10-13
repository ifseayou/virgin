package com.isea.virgin.scala.self_pritice

import scala.util.control.Breaks._
import scala.io.StdIn
object Pritice {
  def main(args: Array[String]): Unit = {
    breakable{
      while (true){
        val v = new Visitor
        v.name = StdIn.readLine("请输入姓名：")
        if (v.name.equals("n")){
          println("退出程序...")
          break
        }
        print("请输入年龄：")
        v.age = StdIn.readInt()
        Guard.guard(v)}}}
}
class Visitor{
  var name = ""
  var age = 0
}
object Guard{
  def guard(visitor: Visitor): Unit ={
    if (visitor.age > 18)
      println(visitor.name + "的年龄是：" + visitor.age + "票价是：" + 20 + " 元")
    else
      println(visitor.name + "的年龄是：" + visitor.age + "门票免费..." )
  }
}