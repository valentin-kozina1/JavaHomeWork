package com.pb.kozina.hw6;

public class Animals {
    private String food;
    private String  location;

   /* public  Animals {

    }*/

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return " сидит " + location;
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

}
