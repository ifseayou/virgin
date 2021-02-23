package com.isea.learn.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * @author ifseayou@gmail.com
 * @date 2021/2/12 9:32
 * @target:
 */
public class Sort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            System.out.println("warn is forbidden...");
            return;
        }
        int middle = L + (R - L) / 2;
        sortProcess(arr, L, middle);
        sortProcess(arr, middle + 1, R);
        merge(arr, L, middle, R);
    }

    private static void merge(int[] arr, int L, int middle, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = middle + 1;
        int i = 0;
        while (p1 <= middle && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortP(arr, 0, arr.length - 1);
    }

    private static void sortP(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, (L + new Random().nextInt(R - L + 1)), R);
            int[] p = partition(arr, L, R);
            sortP(arr, L, p[0] - 1);
            sortP(arr, p[1] + 1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 建立大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 进行堆排序
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            System.out.println("forbidden...");
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = (left + 1 < heapSize && arr[left] < arr[left + 1]) ?
                    left + 1 :
                    left;
            largest = arr[index] > arr[largest] ? arr[index] : arr[largest];
            if (index == largest) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 用基数排序实现数组中找到相邻两个数中的最大差值：
    public static int MaxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if (max == min) {
            return 0;
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], min, max, len);
            maxs[bid] = hasNum[bid] ? Math.max(arr[i], maxs[bid]) : arr[i];
            mins[bid] = hasNum[bid] ? Math.min(arr[i], mins[bid]) : arr[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(mins[i] - lastMax, res);
                lastMax = mins[i];
            }
        }
        return res;
    }

    private static int bucket(int i, int min, int max, int len) {
        return (int) ((i - min) * len / (max - min));
    }

    /**
     * 转圈打印矩阵
     */
    public void printCircleMatrix(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }

    }

    private void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.println(matrix[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.println(matrix[i][tC]);
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.println(matrix[tR][curC++]);
            }
            while (curR != dR) {
                System.out.println(matrix[curR++][dC]);
            }
            while (curC != tC) {
                System.out.println(matrix[dR][curC--]);
            }
            while (curR != tR) {
                System.out.println(matrix[curR++][tC]);
            }
        }


    }

    /**
     * 矩阵旋转
     */

    public void roteteMatrix(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a < c) {
            rotateEdge(matrix, a++, b++, c--, d--);
        }
    }

    private void rotateEdge(int[][] matrix, int a, int b, int c, int d) {
        int times = d - b;
        for (int i = 0; i != times; i++) {
            int tmp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = tmp;
        }
    }

    /**
     * 使用固定数组实现一个栈结构：
     */
    class ArrayStack {
        private int[] stack;
        private int size;

        public ArrayStack(int initialSize) {
            if (initialSize < 0) {
                throw new IllegalArgumentException("forbidden...");
            }
            stack = new int[initialSize];
            size = 0;
        }

        public void push(int num) {
            if (size == stack.length - 1) {
                throw new IllegalArgumentException("full...");
            }
            stack[size++] = num;
        }

        public int pop() {
            if (size == 0) {
                throw new IllegalArgumentException("empty");
            }
            return stack[--size];
        }

        public int peek() {
            if (size == 0) {
                throw new IllegalArgumentException("empty...");
            }
            return stack[size - 1];
        }
    }

    /**
     * 使用固定数组实现队列
     */

    class ArrayQueue {
        private int[] arr;
        private int size;
        private int start;
        private int end;

        public ArrayQueue(int initialSize) {
            if (initialSize < 0) {
                throw new IllegalArgumentException("forbidden...");
            }
            arr = new int[initialSize];
            start = 0;
            end = 0;
            size = 0;
        }

        public void push(int num) {
            if (size == arr.length) {
                throw new IllegalArgumentException("full.");
            }
            size++;
            arr[end] = num;
            end = (end + 1) == arr.length ? 0 : end + 1;
        }

        public int poll() {
            if (size == 0) {
                throw new IllegalArgumentException("empty..");
            }
            size--;
            int tmp = start;
            start = (start + 1) == arr.length ? 0 : start + 1;
            return arr[tmp];
        }
    }

    /**
     * 在实现栈的基础上，返回栈中最小的元素
     *
     * @param
     */
    class MinStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MinStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int num) {
            if (stackMin.isEmpty()) {
                stackMin.push(num);
            } else if (stackMin.pop() < num) {
                stackMin.push(stackMin.push(stackMin.pop()));
            } else {
                stackMin.push(num);
            }
            stackData.push(num);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new IllegalArgumentException("empty..");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackData.isEmpty()) {
                throw new IllegalArgumentException("empty...");
            }
            return stackMin.peek();
        }
    }

    /**
     * 两个队列实现一个栈结构
     */
    class DoubleQueueStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public DoubleQueueStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int num) {
            data.add(num);
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new IllegalArgumentException("empty..");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swaap();
            return res;
        }

        public int poll() {
            if (data.isEmpty()) {
                throw new IllegalArgumentException("empty..");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            swaap();
            return data.poll();
        }

        private void swaap() {
            Queue<Integer> tmp = data;
            data = help;
            help = tmp;
        }
    }

    class TwoStackQueue {
        private Stack<Integer> push;
        private Stack<Integer> pop;

        public TwoStackQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void push(int num) {
            push.push(num);
        }

        public int pop() {
            if (pop.isEmpty() && push.isEmpty()) {
                throw new RuntimeException("empty..");
            }
            dao();
            return pop.pop();
        }

        public int peek() {
            if (pop.isEmpty() && push.isEmpty()) {
                throw new RuntimeException("empty..");
            }
            dao();
            return pop.peek();
        }

        private void dao() {
            if (!pop.isEmpty()) {
                return;
            }
            while (!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
    }

    class Node {
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class DNode {
        private int data;
        private DNode next;
        private DNode last;

        public DNode() {
        }

        public DNode(int data) {
            this.data = data;
            this.last = null;
            this.next = null;
        }
    }

    public Node reverseLinkList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<Node> help = new Stack<>();
        Node cur = head;
        while (cur != null) {
            help.push(cur);
            cur = cur.next;
        }
        head = help.pop();
        cur = head;
        while (help.isEmpty()) {
            cur.next = help.pop();
            cur = cur.next;
        }
        return head;
    }

    public Node reverseLinklist(Node head){
        Node cur = head;
        Node pre = null;
        while(cur!= null){
            cur = head.next;
            head.next=pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

    class DoubleNode{
        private int value;
        private DoubleNode next;
        private DoubleNode last;

        public DoubleNode(){}
        public DoubleNode(int data){
            this.value = data;
            next = null;
            last = null;
        }
        public DoubleNode reverseLinkList(DoubleNode head){
            DoubleNode pre = null;
            DoubleNode next = null;
            while(head != null){
                next = head.next;
                head.next = pre;
                head.last = next;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    private static class TreeNode {
        private Integer val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public static TreeNode getSucessorNode(TreeNode node){
        if(node == null) return null;
        if (node.right!= null){
            return getMostLeft(node.right);
        }else {
            TreeNode parent = node.parent;
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            System.out.println("forbidden..");
            return parent;
        }
    }

    private static TreeNode getMostLeft(TreeNode node) {
        if(node == null) return null;
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    public static boolean isCompleteBinaryTree(TreeNode head){
        if(head == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode left = null;
        TreeNode right = null;
        boolean leaf = false;
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            left = head.left;
            right = head.right;
            if ((leaf && (left != null && right != null))|| (left == null && right != null))
                return false;
            if (left != null) queue.offer(left);
            if (right != null) queue.offer(right);
            else leaf = true;
        }
        return true;
    }

    /**
     * 一颗完全二叉树的个数，< O(N)
     * @return
     */
    public static int nodeNum(TreeNode node){
        if(node == null)  return 0;
        return bs(node,1,getLeftLevel(node,1));
    }

    /**
     * 以node为根节点，层树在level 的节点的个数
     * @param node
     * @param level
     * @param h
     * @return
     */
    private static int bs(TreeNode node, int level, int h) {
        if(level == h) return 1;
        if (getLeftLevel(node.right,level +1) == h)
            return 1 << (h-level) + bs(node.right,level + 1,h);
        else
            return 1 << (h -level -1) + bs(node.left,level + 1,h);
    }

    private static int getLeftLevel(TreeNode node, int level) {
        while(node != null){
            level ++;
            node = node.left;
        }
        return level -1;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(new Random().nextInt(4));
        }
    }
}
