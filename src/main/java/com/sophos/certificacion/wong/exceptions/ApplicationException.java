package com.sophos.certificacion.wong.exceptions;

public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String EMPTY_CAR = "Not products have been added empty cart";

    public ApplicationException(String e) {
        super(e);
    }

}
