/**
 * count['a'] 表示的意思
 */
int[] count =  new int[256];  每一为默认都是0
count['a'] 表示的结果实际上是 count[97] 该值为0

/**
 * (char) 97表示的意思
 */
(char) 97 // 打印出来是 'a'

/**
 * java中的位运算
 */
&  与运算 同1为1否则为0  如: 1 & 1 = 1 ; 2 & 1 = 0
|  或运算 有一个是1即为1 如: 1 | 2 = 3
^  异或   不同为1否则为0 如: 1 ^ 2 = 3 ; 2 ^ 2 = 0

/**
 * for 循环的循环次数
 */
for(int i = x ; i < y; i ++) x为负数, 循环次数为  y-x,x截止到y-1

/**
 * i < arr.lenth 和 i != arr.lenth的效果是一样的
 */
for(int i = 0; i < arr.lenth; i ++) 等效于 for(int i = 0; i ! arr.lenth;i++)

/**
 * 关于排序的稳定性问题的讨论
 */
冒泡排序: 可以做到,每次遇到相等的值,不发生交换
插入排序: 可以做到,每次遇到相等的值,不发生交换
选择排序: 不可以,如 5,5,5,1,3

归并排序: 可以,每次相等的时候,总是优先放入左边的值
快速排序: 不可以,随机的时候,就破坏了稳定性
堆排序: 不可以,建堆的时候,就破坏的稳定性  4,4,4,5,5

/**
 *
 */
