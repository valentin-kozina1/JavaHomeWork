package com.pb.kozina.hw7;

public class Tie  extends Clothes implements ManClothes{

    public Tie(Size size, int price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void dressMan(){
        System.out.println("Мужская одежда - ");
    };
}
