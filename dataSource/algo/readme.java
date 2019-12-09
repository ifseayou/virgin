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


