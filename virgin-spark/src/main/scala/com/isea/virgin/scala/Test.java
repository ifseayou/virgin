package com.isea.virgin.scala;
public class Test {
    public static void main(String[] args) {
        new Son();
        /**
         * 父类的静态代码块...
         * 子类的静态代码块...
         * 父类的普通代码块...
         * 父类的构造器...
         * 子类的普通代码块...
         * 子类的构造器...
         */
    }
}
class Father {
    static { System.out.println("父类的静态代码块...");}
    { System.out.println("父类的普通代码块..."); }
    public Father() { System.out.println("父类的构造器..."); }
}
class Son extends Father {
    static { System.out.println("子类的静态代码块...");}
    public Son() { System.out.println("子类的构造器..."); }
    { System.out.println("子类的普通代码块..."); }
}

