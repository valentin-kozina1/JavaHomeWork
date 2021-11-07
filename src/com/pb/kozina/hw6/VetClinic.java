package com.pb.kozina.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {
    public static void main(String[] args) throws Exception{
        Dog dog = new Dog();
        Cat cat = new Cat();
        Horse horse = new Horse();

        dog.setName(" собака ");
        dog.setFood(" корм Chappy ");
        dog.setLocation(" в будке ");
        dog.setDog_accessory(" в ошейнике ");
        cat.setName(" кошка ");
        cat.setFood(" корм Whiskas ");
        cat.setLocation(" на заборе ");
        cat.setCat_accessory(" с блюдцем ");
        horse.setName(" лошадь ");
        horse.setFood(" овес ");
        horse.setLocation(" в конюшне ");
        horse.setHorse_accessory(" с седлом ");

        System.out.print(dog.sleep() + "," + dog.eat() + dog.getFood() + "," +
                dog.getDog_accessory() + " сидит " + dog.getLocation() + "," + dog.makeNoise());
        System.out.println();
        System.out.print(cat.sleep() + "," + cat.eat() + cat.getFood() + "," +
                cat.getCat_accessory() + " сидит " + cat.getLocation() + "," + cat.makeNoise());
        System.out.println();
        System.out.print(horse.sleep() + "," + horse.eat() + horse.getFood() + "," +
                horse.getHorse_accessory() + " стоит " + horse.getLocation() + "," + horse.makeNoise());
        System.out.println("");
        System.out.println("-----------------------");

        Animals[] animal = new Animals[] {dog, cat, horse};

        Veterinarian vt = new Veterinarian();

        Class vtClazz = Class.forName("com.pb.kozina.hw6.Veterinarian");
        Constructor constr = vtClazz.getConstructor(new Class[] {});
        Object obj = constr.newInstance();


        for (Animals c: animal) {
            if (c instanceof Dog) {
                Dog dg = (Dog) c;
                System.out.println(dg.getName() + " пришла на прием в вет. клинику.");
            } else
                if (c instanceof Cat){
                    Cat ct = (Cat) c;
                    System.out.println(ct.getName() + " пришла на прием в вет. клинику.");
                } else
                    if (c instanceof Horse) {
                        Horse hr = (Horse) c;
                        System.out.println(hr.getName() + " пришла на прием в вет. клинику.");
                    }
            vt.treatAnimals(c);
        }
    }
}
