package com.pb.kozina.hw10;

public class Main {
    public static void main(String[] args) {
       NumBox<Integer> numBox = new NumBox<>(5);
     try {
      numBox.add(new Integer(7));
      numBox.add(new Integer(4));
      numBox.add(new Integer(2));
      numBox.add(new Integer(1));
      numBox.add(new Integer(6));
      numBox.add(new Integer(9));
     } catch (ArrayIndexOutOfBoundsException e) {
         System.out.println(e.getMessage());
   //   e.printStackTrace();
     }

        System.out.println("Значение третьего элемента массива " +  numBox.get(2).doubleValue());
        System.out.println("В массиве заполнено " + numBox.length() + " элементов");
        System.out.println("среднее арифметическое элементов массива " +  numBox.average());
        System.out.println("Сумма всех элементов массива = " + numBox.sum());
        System.out.println("Максимальный элемент массива " + numBox.max().doubleValue());

        System.out.println("_________________________________________");

        NumBox<Double> numBox2 = new NumBox<>(5);
        try {
        numBox2.add(new Double(7.5));
        numBox2.add(new Double(4.1));
        numBox2.add(new Double(2.7));
        numBox2.add(new Double(1.6));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            //   e.printStackTrace();
        }

        System.out.println("Значение третьего элемента массива " +  numBox2.get(2).doubleValue());
        System.out.println("В массиве заполнено " + numBox2.length() + " элементов");
        System.out.println("среднее арифметическое элементов массива " +  numBox2.average());
        System.out.println("Сумма всех элементов массива = " + numBox2.sum());
        System.out.println("Максимальный элемент массива " + numBox2.max().doubleValue());

        System.out.println("_________________________________________");

        NumBox<Float> numBox3 = new NumBox<>(5);
        try {
        numBox3.add(new Float(1));
        numBox3.add(new Float(9));
        numBox3.add(new Float(2));
        numBox3.add(new Float(7));
        } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
        //   e.printStackTrace();
        }

        System.out.println("Значение третьего элемента массива " +  numBox3.get(2).doubleValue());
        System.out.println("В массиве заполнено " + numBox3.length() + " элементов");
        System.out.println("среднее арифметическое элементов массива " +  numBox3.average());
        System.out.println("Сумма всех элементов массива = " + numBox3.sum());
        System.out.println("Максимальный элемент массива " + numBox3.max().doubleValue());
    }

}
