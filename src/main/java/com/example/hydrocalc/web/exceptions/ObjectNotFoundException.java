package com.example.hydrocalc.web.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private final String text;

    public ObjectNotFoundException(String text) {
        super("could not find: " + text + "!");
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
