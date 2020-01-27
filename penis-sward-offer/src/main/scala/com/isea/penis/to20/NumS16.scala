package com.isea.penis.to20

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/24 11:17
  * @target: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
  */
object NumS16 {
  def merge(head1:ListNode, head2:ListNode): ListNode ={
    if (head1 == null) return head2
    if (head2 == null) return head1

    var list1: ListNode = head1
    var list2: ListNode = head2
    var dummyHead = new ListNode(1,null)
    val head: ListNode = dummyHead

    while (list1 != null && list2 != null){
      if (list1.value < list2.value){
        dummyHead.next = list1
        dummyHead = list1
        list1 = list1.next
      }else{
        dummyHead.next = list2
        dummyHead = list2
        list2 = list2.next
      }
    }

    if (list1 != null) dummyHead.next = list1
    if (list2 != null) dummyHead.next = list2
    return head.next
  }
}
