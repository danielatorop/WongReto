package com.sophos.certificacion.wong.exceptions;

public class AssertionError extends RuntimeException {

    public static final String EMPTY_CAR = "NOT PRODUCTS HAVE BEEN ADDED EMPTY CART";
    public static final String NAME_SEARCHED_DOES_NOT_MATCH = "THE NAME OF THE PRODUCT DOES NOT MATCH THE SEARCHED";
    //public static final String DD = "THE NAME OF THE PRODUCT DOES NOT MATCH THE SEARCHED";


    public AssertionError(String message, Throwable cause) {
        super(message, cause);

    }

}
