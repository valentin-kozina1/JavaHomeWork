package com.pb.kozina.hw6;

public class Main {
    public static void main(String[] args){
        Dog dog = new Dog();
        Cat cat = new Cat();
        Horse horse = new Horse();

        dog.setName(" собака ");
        dog.setFood(" корм Chappy ");
        dog.setLocation(" в будке ");
        cat.setName(" кот ");
        cat.setFood(" корм Whiskas ");
        cat.setLocation(" на заборе ");
        horse.setName(" лошадь ");
        horse.setFood(" овес ");
        horse.setLocation(" в конюшне ");

        System.out.print(dog.getName() + dog.sleep() + "," + dog.eat() + dog.getFood() + "," +
                dog.getLocation() + "," + dog.makeNoise());
        System.out.println();
        System.out.print(cat.getName() + cat.sleep() + "," + cat.eat() + cat.getFood() + "," +
                cat.getLocation() + "," + cat.makeNoise());
        System.out.println();
        System.out.print(horse.getName() + horse.sleep() + "," + horse.eat() + cat.getFood() + "," +
                horse.getLocation() + "," + horse.makeNoise());
    }
}
