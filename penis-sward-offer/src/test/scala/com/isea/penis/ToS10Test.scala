package com.isea.penis

import com.isea.penis.to10.NumS1
import org.junit._
/**
  * @author ifseayou@gmail.com
  * @date 2020/1/6 20:07
  * @target:
  */
class To10Test {
  @Test
  def testNumS1(): Unit ={
    val matrix = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))
    Assert.assertTrue(NumS1.find(5,matrix))
  }


}
