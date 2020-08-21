package com.sophos.certificacion.wong.exceptions;

public class AssertionError extends RuntimeException {

    public static final String EMPTY_CAR = "NOT PRODUCTS HAVE BEEN ADDED EMPTY CART";

    public AssertionError(String message, Throwable cause) {
        super(message, cause);

    }

}
