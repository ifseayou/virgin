package com.isea.virgin.xml.beans;

/**
 * @author isea_you
 * @date 2019/11/4
 * @time 7:52
 * @target:
 */
public class Person {
    // Navigate to spring bean declarations
    private String name;
    private int age;
    private Car car;

    public Person() { // Navigate to spring bean
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Car getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    } // Navigate to spring bean property

    public void setAge(int age) {
        this.age = age;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

}
