package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.UserBrowser;

import java.util.List;

public interface UserBrowserService {
    void registerUser(UserBrowser userBrowser);

    List<UserBrowser> findAll();
}
