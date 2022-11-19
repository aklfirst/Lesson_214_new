package org.example;

public class WrongItemException extends RuntimeException {

    public WrongItemException(String message) {
        super(message);
    }

}