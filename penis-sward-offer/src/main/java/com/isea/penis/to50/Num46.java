package com.isea.penis.to50;

/**
 * @author isea_you
 * @date 2019/11/10
 * @time 11:48
 * @target: 有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....
 * 这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 *
 * !!! 本题的本质是约瑟夫环问题，构建单向循环链表能够很好的解决这个问题！
 * 第一步：生成一个单向循环链表
 * 第二步：不断提出链表中的数据
 */
public class Num46 {

    public static class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0){
            return -1;
        }
        Node p = generateList(n);
        while(p != p.next){ // 循环终止的条件
            for (int i = 0;i < m - 1; i ++){
                p = p.next;
            }
            p.next = p.next.next; // 最好画个图
        }
        return p.val;
    }

    /**
     * 生成一颗循环链表
     * @param n
     * @return
     */
    public Node generateList(int n){
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < n ; i ++){
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = head; // 尾节点指向头节点
        return cur;
    }

    public static void main(String[] args) {
        Num46 num46 = new Num46();
        System.out.println(num46.LastRemaining_Solution(7, 3));
        System.out.println(num46.LastRemaining_Solution(7, 11));
        System.out.println(num46.LastRemaining_Solution(7, 3));
        System.out.println(num46.LastRemaining_Solution(5, 3));
    }
}
