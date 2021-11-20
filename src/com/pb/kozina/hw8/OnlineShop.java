package com.pb.kozina.hw8;

import java.util.Scanner;


public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("зарегистрируйтесь на сайте");
            System.out.println("придумайте логин: ");

            String login = scan.next();
            System.out.println("придумайте пароль: ");
            String password = scan.next();
            System.out.println("повторите пароль: ");
            String confirmPassword = scan.next();
            auth.signUp(login, password, confirmPassword);
        }
        catch (WrongLoginException | WrongPasswordException l) {
            System.out.println(l.getMessage());
            return;
        }

        try {
            System.out.println("пройдите авторизацию на сайте");
            System.out.println("введите логин: ");

            String login = scan.next();
            System.out.println("введите пароль: ");
            String password = scan.next();
            auth.signIn(login, password);
        }
        catch (WrongLoginException l) {
            System.out.println(l.getMessage());
        }
    }
}
