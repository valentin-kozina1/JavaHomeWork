package com.pb.kozina.hw8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;
    private String confirmPassword;

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        Pattern pattern = Pattern.compile("\\w{5,20}");
        Matcher matcher = pattern.matcher(login);
        if (matcher.matches()) {
            System.out.println("login OK");
        } else {
            throw new WrongLoginException("логин должен содержать только цифры и буквы латинского алфавита, " +
                    "и былтьдлиной от 5 до 20 символов");
        }

        if (password.equals(confirmPassword)) {
            pattern = Pattern.compile("\\w{5}");
            matcher = pattern.matcher(password);
            if (matcher.find()) {
                System.out.println("password OK");
            } else {
                throw new WrongPasswordException("неверный пароль");
            }
        } else {
            throw new WrongPasswordException("Введенные пароли отличаются друг от друга");
        }

        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        System.out.println("Вы успешно зарегистрироались на сайте");

    }

    public void signIn(String login, String password) throws WrongLoginException {
        if (login.equals(this.login) && password.equals(this.password)) {
            System.out.println("Вы успешно вошли на сайт под логином " + this.login);
        } else {
            throw new WrongLoginException("неверно введен логин или пароль");
        }
    }
}