package com.pb.kozina.hw6;

public class Horse extends Animals{

    private String name;
    private String horse_accessory;

    public String getHorse_accessory() {
        return horse_accessory;
    }

    public void setHorse_accessory(String horse_accessory) {
        this.horse_accessory = horse_accessory;
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
        return "  ржет ";
    }

    @Override
    public String eat() {
        return " ест ";
    }
}


