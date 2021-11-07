package com.pb.kozina.hw6;

public class Cat extends Animals{

    private String name;
    private String cat_accessory;

    public String getCat_accessory() {
        return cat_accessory;
    }

    public void setCat_accessory(String cat_accessory) {
        this.cat_accessory = cat_accessory;
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
        return "  мяукает ";
    }

    @Override
    public String eat() {
        return " ест ";
    }
}

