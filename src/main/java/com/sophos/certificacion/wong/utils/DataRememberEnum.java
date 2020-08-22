package com.sophos.certificacion.wong.utils;

public enum DataRememberEnum {
    NAME_PRODUCT("nameproduct");
    private final String value;

    DataRememberEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
