/*
package com.isea.scala.mytrait

// 叠加特质的案例
object TraitDemo02 {
  def main(args: Array[String]): Unit = {
    var mysql = new MySQL with DB
    mysql.insert(100)
  }
}

class MySQL{
}

trait Operate{
  println("Operate....")
  def insert(num : Int)
}

trait Data extends Operate{
  println("Data...")

  override def insert(num: Int): Unit = {
    println("插入数据：" + num)
  }
}

trait DB extends Data{
  println("DB...")

  override def insert(num: Int): Unit = {
    println("向数据库：")
    super.insert(num)
  }
}

trait File extends Data{
  println("File...")

  override def insert(num: Int): Unit = {
    println("向文件中：")
    super.insert(num)
  }
}


*/
