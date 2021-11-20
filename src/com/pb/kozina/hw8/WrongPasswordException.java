package com.pb.kozina.hw8;

public class WrongPasswordException extends Exception {

    public WrongPasswordException(String msg) {
        super(msg);
    }

    public WrongPasswordException() {
    }
}
