package com.isea.penis.to10

import scala.collection.mutable

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/15 19:20
  * @target: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
  */
object NumS5 {
  private val stack1 = new mutable.Stack[Int]
  private val stack2 = new mutable.Stack[Int]

  def push(ele:Int) = {
    stack1.push(ele)
  }

/*
  val pop = ()=> {
    dump()
    if (stack2.isEmpty) throw  new Exception("the queue is empty...")
    stack2.pop()
  }
*/

  def pop= {
    dump()
    if (stack2.isEmpty) throw  new Exception("the queue is empty...")
    stack2.pop()
  }

  /**
    *  倾倒操作，将stack1中的倾倒到stack2中
   */
  def dump() =  {
    if (stack2.isEmpty) {
      while (!stack1.isEmpty){
        stack2.push(stack1.pop())
      }
    }
  }
}
