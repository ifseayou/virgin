package com.isea.penis


import com.isea.penis.to10.{NumS1, NumS2, NumS3}
import org.junit._

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/6 20:07
  * @target:
  *
  */
class ToS10Test {
  @Test
  def testNumS1(): Unit ={
    val matrix = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))
    Assert.assertTrue(NumS1.find(5,matrix))
  }

  @Test
  def testNumS1Fin2(): Unit ={
    val matrix = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))
    Assert.assertTrue(NumS1.find2(5)(matrix))
  }

  @Test
  def testNumS2():Unit = {
    val str = NumS2.replace("we are happy")
    println(str)
  }

  @Test
  def testNumS3():Unit = {
    val list: List[Int] = NumS3.printListFromTailToHead(List(1,2,3,4))
    list.foreach(print(_))
  }



  @Test
  def test():Unit = {

  }
}

