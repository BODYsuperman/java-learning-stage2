package com.alex.d3_method_reference;

public class Test4 {

    public static void main(String[] args) {

        Create c1 = new Create() {
            @Override
            public Car create(String name) {
                return new Car(name);
            }
        };

        Car c =  c1.create("Benze");

//        Create c2 = name -> new Car(name);

        Create c2= Car::new;
        System.out.println(c);
    }
}


@FunctionalInterface
interface Create{
    Car create(String name);
}

class Car{
    private  String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
