package com.pb.kozina.hw7;

import java.awt.*;

public class Atelier {

    public static void dressMan(Clothes[] clothes){
        System.out.println(" Мужская одежда:");
        for (Clothes clothe: clothes) {
            if (clothe instanceof Tshirt) {
                Tshirt a = (Tshirt) clothe;
                System.out.println(" футболка - " + a.getSize() + " цвет - " +
                        a.getColor() + " цена - " + a.getPrice());
            } else
            if (clothe instanceof Pants) {
                Pants a = (Pants) clothe;
                System.out.println(" штаны - " + a.getSize() + " цвет - " +
                        a.getColor() + " цена - " + a.getPrice());
            }else
            if (clothe instanceof Tie) {
                Tie a = (Tie) clothe;
                System.out.println(" галстук - " + a.getSize() + " цвет - " +
                        a.getColor() + " цена - " + a.getPrice());
            }
        }
    }

    public static void dressWoman(Clothes[] clothes) {
        System.out.println(" Женская одежда:");
        for (Clothes clothe : clothes) {
            if (clothe instanceof Tshirt) {
                Tshirt a = (Tshirt) clothe;
                System.out.println(" футболка, - " + a.getSize() + " цвет - " +
                        a.getColor() + " цена - " + a.getPrice());
            } else if (clothe instanceof Pants) {
                Pants a = (Pants) clothe;
                System.out.println(" штаны - " + a.getSize() + " цвет - " +
                        a.getColor() + " цена - " + a.getPrice());
            } else if (clothe instanceof Skirt) {
                Skirt a = (Skirt) clothe;
                System.out.println(" юбка - " + a.getSize() + " цвет - " +
                        a.getColor() + " цена - " + a.getPrice());
            }
        }
    }
    public static void main(String[] args) {
        Tshirt tshirt = new Tshirt( Size.XS, 250,  "красная");
        Pants pants = new  Pants( Size.XXS, 700, "серые");
        Skirt skirt = new  Skirt( Size.S, 500, "черная");
        Tie tie = new  Tie( Size.L, 400, "оранжевый");

        Clothes[] clothes = {tshirt, pants, skirt, tie};
        dressMan(clothes);
        dressWoman(clothes);


    }
}
