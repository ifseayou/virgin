package com.isea.penis

import com.isea.penis.to20._
import org.junit._

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/6 20:07
  * @target:
  *
  */
class ToS20Test {
  @Test
  def testNumS11(): Unit ={
    Assert.assertEquals(1,NumS11.NumberOf1(2))
    Assert.assertEquals(2,NumS11.NumberOf1(3))
    Assert.assertEquals(1,NumS11.NumberOf1(4))
    Assert.assertEquals(2,NumS11.NumberOf1(5))
  }

  @Test
  def testNumS12(): Unit ={
    Assert.assertEquals(8.0,NumS12.power(2.0,3),0.01)
    Assert.assertEquals(0.5,NumS12.power(2.0,-1),0.01)
    Assert.assertEquals(0.125,NumS12.power(2.0,-3),0.01)
  }

  @Test
  def testNumS13(): Unit ={
    val arr = Array(4, 5, 3, 2, 1, 6)
    Assert.assertArrayEquals(Array(5,3,1,4,2,6),NumS13.reOrderArray(arr))
  }

  @Test
  def testNumS14(): Unit ={
    val head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))))
    Assert.assertEquals(4,NumS14.FindKthToTail(head,1).value)
    Assert.assertEquals(3,NumS14.FindKthToTail(head,2).value)
    Assert.assertEquals(2,NumS14.FindKthToTail(head,3).value)
  }

  @Test
  def testNumS15(): Unit ={
    val head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))))
    Assert.assertEquals(4,NumS15.reverseList(head).value)
  }

}

