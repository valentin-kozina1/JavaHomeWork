package com.pb.kozina.hw6;

public class Veterinarian {

    public static void treatAnimals(Animals animal) {
        System.out.println("Пришедшее на прием животное ест"+ animal.getFood() + ", живет "
                + animal.getLocation());
    }
}
