package com.jinming.com.ioc;

public class Animal {
    IFood food;

    public Animal(IFood food) {
        this.food = food;
    }

    public void eat() {
        System.out.println(this.food.toString());
    }
}
