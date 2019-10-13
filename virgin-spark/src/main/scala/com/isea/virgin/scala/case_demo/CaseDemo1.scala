package com.isea.virgin.scala.case_demo

object CaseDemo1 {
  println("ok...")

}

abstract class Account // 抽象类

// Dollar 是一个样例类，继承Account，构造器是Dollar(value : Double)
case class Dollar(value : Double) extends Account

// Currency 是一个样例类，继承Account，构造器是 Currency(value : Double,unit : String)
case class Currency(value : Double,unit : String) extends Account

// NoAccount也是一个样例类
case object NoAccount extends Account

case object AAA

/*
 样例类会自动生成一系列的方法，比如，copy，copy$default,toString,equals,apply,unapply,hashCode
 样例类是为了模式匹配而优化的类，构造器中的每一个参数，都成为val，在样例类对应的伴生对象中，提供了
 apply方法，可以不用new就能够获取对象。
  */