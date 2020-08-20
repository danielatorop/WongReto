package com.sophos.certificacion.wong.exceptions;

public class ElementNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String CLICK_ELEMENT_ERROR = "ERROR TO CLICK THE ELEMENT: ";
    public static final String WAIT_ELEMENT_ERROR = "ERROR TO WAIT THE ELEMENT: ";

    public ElementNotFoundException(String e) {
        super(e);
    }
}
