package com.isea.virgin;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object person1 = ctx.getBean(Person.class);
//        System.out.println(person1); // Person{name='Tom', age=22, car=Car{brand='Audi', address='<Gummy>', price=250.0}}
    }
}
