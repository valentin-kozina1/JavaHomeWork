package com.pb.kozina.hw6;

public class Horse extends Animals{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String makeNoise(){
        return "  ржет ";
    }

    public String eat() {
        return " ест ";
    }
}


