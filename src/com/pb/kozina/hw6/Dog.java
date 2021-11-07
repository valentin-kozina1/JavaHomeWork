package com.pb.kozina.hw6;

import java.util.Objects;

public class Dog extends Animals{
    private String name;
    private String dog_accessory;

    public String getDog_accessory() {
        return dog_accessory;
    }

    public void setDog_accessory(String dog_accessory) {
        this.dog_accessory = dog_accessory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sleep() {
        return name + super.sleep();
    }

    @Override
    public String makeNoise(){
        return "  лает ";
    }

    @Override
    public String eat() {
        return " ест ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name) && Objects.equals(dog_accessory, dog.dog_accessory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, dog_accessory);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dog_accessory='" + dog_accessory + '\'' +
                '}';
    }
}

