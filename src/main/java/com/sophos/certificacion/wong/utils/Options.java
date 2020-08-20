package com.sophos.certificacion.wong.utils;

public enum Options {
    PAGE("https://www.wong.pe/especiales/cyberwong");
    private final String URL;

    Options(String url) {
        this.URL = url;
    }

    public String url() {
        return URL;
    }
}
