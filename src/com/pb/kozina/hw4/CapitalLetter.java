package com.pb.kozina.hw4;

import java.util.Scanner;

public class CapitalLetter {

    static String Upper(String str){
        String[] mas = str.split(" ");
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String m:mas) {
            if (m.isEmpty()) {
                i++;
                continue;
            } else
            if (Character.isLetter(m.charAt(0))) {
                mas[i] = m.substring(0, 1).toUpperCase() + m.substring(1);
                builder.append(mas[i]);
                builder.append(' ');
                i++;
            } else {
                builder.append(mas[i]);
                builder.append(' ');
                i++;
            }
        }
        str = builder.toString();
        return str;
    }

    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку ");
        String str = scan.nextLine();
        String result = Upper(str);
        System.out.println(result);


    }
}
