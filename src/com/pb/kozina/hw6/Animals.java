package com.pb.kozina.hw6;

import java.util.Objects;

public class Animals {
    private String food;
    private String  location;


    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String makeNoise(){
        return " животное рычит";
    }

    public String eat() {
        return " животное питается ";
    }

    public String sleep() {
        return " спит";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return Objects.equals(food, animals.food) && Objects.equals(location, animals.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location);
    }

    @Override
    public String toString() {
        return "Animals{" +
                "food='" + food + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
