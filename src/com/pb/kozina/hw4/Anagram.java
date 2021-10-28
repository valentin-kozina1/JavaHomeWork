package com.pb.kozina.hw4;

import java.util.Scanner;
import java.util.Arrays;

public class Anagram {

    static char[] Arr(String str){
        String str_rez = str.toLowerCase();
        char[] Array = str_rez.toCharArray();
        char[] Array_rez = new char[Array.length];
        int i = 0;
        for (char a:Array) {
            if (Character.isLetter(a)) {
                Array_rez[i] = a;
                i++;
            }
        }
        char[] Array_rez2 = Arrays.copyOfRange(Array_rez, 0, i);
        Arrays.sort(Array_rez2);
        return Array_rez2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку 1 ");
        String str1 = scan.nextLine();
        System.out.println("Введите строку 2 ");
        String str2 = scan.nextLine();

        char[] str1_mas = Arr(str1);
        char[] str2_mas = Arr(str2);

        if (Arrays.equals(str1_mas, str2_mas)) {
            System.out.println("Анаграмма !");
        } else {
            System.out.println("это не анаграмма");
        }


    }
}
