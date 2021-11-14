package com.pb.kozina.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{

    public Tshirt(Size size, int price, String color){
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
        System.out.println("Мужская одежда - футболка, размера - " + getSize() + " цвет - " +
                getColor() + " цена - " + getPrice());
    };

    @Override
    public void dressWoman(){
        System.out.println("Женская одежда - футболка, размера - " + getSize() + " цвет - " +
                getColor() + " цена - " + getPrice());
    };
}
