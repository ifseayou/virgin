package com.isea.penis.to20

import scala.collection.mutable

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/27 15:57
  * @target: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
  */
object NumS20 {
  private val stack1 = new mutable.Stack[Int]()
  private val stack2 = new mutable.Stack[Int]()

  def push(target:Int): Unit ={
    stack1.push(target)
    if (stack2.isEmpty || target < stack2.top) stack2.push(target)
    else stack2.push(stack2.top)
  }

  def pop():Int = {
    if (stack1.isEmpty) throw new IllegalArgumentException("stack is empty..")
    stack2.pop()
    stack1.pop()
  }

  def top():Int = {
    if (stack1.isEmpty) throw new IllegalArgumentException("stack is empty...")
    stack1.top
  }

  def min():Int = {
    if (stack2.isEmpty)throw new IllegalArgumentException("stack is empty...")
    stack2.top
  }
}
