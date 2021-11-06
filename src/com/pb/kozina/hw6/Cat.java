package com.pb.kozina.hw6;

public class Cat extends Animals{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String makeNoise(){
        return "  мяукает ";
    }

    public String eat() {
        return " ест ";
    }
}

