package com.isea.penis.to50;

/**
 * @author isea_you
 * @date 2019/11/10
 * @time 12:26
 * @target: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * (1+n) * (n -1 + 1) / 2 = n * (n + 1 ) / 2 => (n^2 + n) / 2
 */
public class Num47 {
    public int Sum_Solution1(int n) {
        int sum = (int) Math.pow(n,2) + n;
        return sum >> 1;
    }

    public int Sum_Solution2(int n) {
        if (n == 0){
            return 0;
        }
        return n + Sum_Solution2(n - 1);
    }

    public int Sum_Solution3(int n){
        boolean b = (n > 0) &&((n += Sum_Solution3(n - 1)) > 0); // 这里是为了语法的需要 &&后面起始是恒成立的！
        return n;
    }


    public static void main(String[] args) {
        Num47 num47 = new Num47();
        System.out.println(num47.Sum_Solution3(5));
        System.out.println(num47.Sum_Solution1(5));
        System.out.println(num47.Sum_Solution2(5));
    }
}
