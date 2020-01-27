package com.isea.penis.to20

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/24 11:16
  * @target: 输入一个链表，反转链表后，输出新链表的表头。
  */
object NumS15 {
  def reverseList(root:ListNode):ListNode = {
    var head = root
    var cur = root
    var pre : ListNode = null
    while (cur != null){
      head = head.next
      cur.next = pre
      pre = cur
      cur = head
    }
    pre
  }
}
