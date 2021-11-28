package com.pb.kozina.hw10;

public class NumBox <T extends Number>{
    private T[] number;

    public NumBox(int size) throws ArrayIndexOutOfBoundsException{     // максимальная длина массива
         number = (T[]) new Number[size];
    }

   public  void  add(T num) {
       if (length()== number.length) {
           throw new ArrayIndexOutOfBoundsException("Массив заполнен");
       } else  number[length()] = num;
    }

    public T get(int index) {
        return  number[index];
    }

    public int length() {
        int i = 0;
        for (T n: number) {
            if (n == null) {
                break;
            }
            i++;
        }
        return i; // вычислить текущее кол-во элементов
    }

    public double average() {
        double avеrage = (sum()/length());
        return  avеrage;        // подсчет среднего арифмитического элементов массива
    }

     public double sum() {
         double sum = 0;
         for (T n: number) {
             if (n != null) {
                 double nNum = n.doubleValue();
                 sum += nNum;
             }
             else  break;
         }
         return  sum;            // сумма всех элементов массива
    }

   public  T max() {
       T maX = number[0];
       for(int i = 0; i < length(); i++){
           if(number[i].doubleValue() > maX.doubleValue()) {
               maX = number[i];
           }
       }
       return maX;
    }
}
