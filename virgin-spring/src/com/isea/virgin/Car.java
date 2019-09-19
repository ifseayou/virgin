package com.isea.virgin;

public class Car {
    private String brand;
    private String address;
    private double price;
    private int maxSpeed;


    public Car(String brand, String address, double price) {
        this.brand = brand;
        this.address = address;
        this.price = price;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';
    }
}
