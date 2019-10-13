package com.isea.virgin.scala.queue

import scala.collection.mutable
object QueueDemo {
  def main(args: Array[String]): Unit = {
    // 创建队列
    val queue1 = new mutable.Queue[Int]
    // 向队列中添加元素100,
    // += 实际上是一个函数： def +=(elem: A): this.type = { appendElem(elem); this }
    queue1 += 100 // queueq.$plus$eq(100)
    queue1 += 100 // 对列中可以有重复的数据
    println("queue1 = " + queue1) // queue1 = Queue(100, 100)

    queue1 ++= List(1,2,3) // 及List中的数据取出来，然后放入到queue1中
    println("queue1 = " + queue1) // queue1 = Queue(100, 100, 1, 2, 3)

    queue1.dequeue() // 出队操作
    println("queue1 = " + queue1) // queue1 = Queue(100, 1, 2, 3)

    queue1.enqueue(666,888)//
    println("queue1 = " + queue1) //queue1 = Queue(100, 1, 2, 3, 666, 888)

    println("queue1.head =" + queue1.head) // 返回队首的元素   queue1.head =100
    println("queue1.last =" + queue1.last) // 返回队尾的元素   queue1.last =888

    // 返回除了队首元素的所有元素  queue1本身没有变化 tail 可以级联使用
    println("queue1.tail = " + queue1.tail) //queue1.tail = Queue(1, 2, 3, 666, 888)
  }
}
