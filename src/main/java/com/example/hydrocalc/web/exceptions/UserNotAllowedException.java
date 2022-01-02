package com.example.hydrocalc.web.exceptions;

public class UserNotAllowedException extends RuntimeException {
    private final String username;

    public UserNotAllowedException(String username) {
        super(username + "is not allowed to do this operation!");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
