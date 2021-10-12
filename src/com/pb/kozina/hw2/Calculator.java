package com.pb.kozina.hw2;

import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите переменную 1: ");
        int operand1 = scan.nextInt();
        System.out.print("Введите знак математического действия ");
        String sign = scan.next();
        System.out.print("Введите переменную 2: ");
        int operand2 = scan.nextInt();
        double result;

        switch (sign) {
            case "+": result =  operand1 + operand2;
                      System.out.print(result );
                break;
            case "-": result =  operand1 - operand2;
                System.out.print(result );
                break;
            case "*": result =  operand1 * operand2;
                System.out.print(result );
                break;
            case "/": if (operand2==0)
            {
                System.out.print("На 0 делить нельзя!" );
                break;
            } else
            {
                result = ((double) operand1 / (double) operand2);
                System.out.print(result);
                break;
            }
            default: System.out.print( "Введено неверное математическое действие");
        }

    }
}
