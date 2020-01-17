package com.isea.penis

import com.isea.penis.to10.NumS4.TreeNode
import com.isea.penis.to10._
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
  def testNumS4():Unit = {
    val arr1 = Array(1, 2, 4, 7, 3, 5, 6, 8)
    val arr2 = Array(4, 7, 2, 1, 5, 3, 8, 6)
    val node: TreeNode = NumS4.reConstructBinaryTree(arr1)(arr2)
    println(node.value)
  }

  @Test
  def testNumS5(): Unit ={
    NumS5.push(1)
    NumS5.push(2)
    NumS5.push(3)
    NumS5.push(4)
    Assert.assertEquals(1,NumS5.pop)
    Assert.assertEquals(2,NumS5.pop)
    Assert.assertEquals(3,NumS5.pop)
    Assert.assertEquals(4,NumS5.pop)

    NumS5.pop
  }

  @Test
  def testNumS6(): Unit ={
    Assert.assertEquals(1,NumS6.minNumberInRotateArray(Array(3,4,5,1,2)));
  }

  @Test
  def testNumS7(): Unit ={
    Assert.assertEquals(1,NumS7.fibonacci(1))
    Assert.assertEquals(1,NumS7.fibonacci(2))
    Assert.assertEquals(2,NumS7.fibonacci(3))
    Assert.assertEquals(3,NumS7.fibonacci(4))
    Assert.assertEquals(5,NumS7.fibonacci(5))
  }

  @Test
  def testNumS8(): Unit ={
    Assert.assertEquals(1,NumS8.JumpFloor(1))
    Assert.assertEquals(2,NumS8.JumpFloor(2))
    Assert.assertEquals(3,NumS8.JumpFloor(3))
    Assert.assertEquals(5,NumS8.JumpFloor(4))
    Assert.assertEquals(8,NumS8.JumpFloor(5))
  }

  @Test
  def testNumS9(): Unit ={
    Assert.assertEquals(1,NumS9.JumpFloorII(1))
    Assert.assertEquals(2,NumS9.JumpFloorII(2))
    Assert.assertEquals(4,NumS9.JumpFloorII(3))
    Assert.assertEquals(8,NumS9.JumpFloorII(4))
    Assert.assertEquals(16,NumS9.JumpFloorII(5))
  }

    @Test
  def testNumS10(): Unit ={
      println(NumS10.RectCover(1))
      println(NumS10.RectCover(2))
      println(NumS10.RectCover(3))
      println(NumS10.RectCover(4))
      println(NumS10.RectCover(5))
  }





  @Test
  def test():Unit = {

  }
}

