package com.isea.penis.to20

import scala.collection.mutable.ArrayBuffer

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/24 10:55
  * @target: 输入一个链表，输出该链表中倒数第k个结点。
  */
object NumS14 {
   def FindKthToTail(head : ListNode,k:Int):ListNode = {
     val res = new ArrayBuffer[ListNode]()
     var cur = head
     while (cur != null){
       res.append(cur)
       cur = cur.next
     }
     if (k > res.length)throw new IllegalArgumentException("Illegal K...")
     return res(res.length - k)
   }

}

case class ListNode(var value:Int,var next:ListNode)
