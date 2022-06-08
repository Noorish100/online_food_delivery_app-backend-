package com.foodApp.Exception;

public class BillNotFoundException extends RuntimeException{

    public BillNotFoundException(String message) {
        super(message);
    }
}
