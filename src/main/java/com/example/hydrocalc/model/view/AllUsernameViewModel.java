package com.example.hydrocalc.model.view;

import java.util.LinkedList;
import java.util.List;

public class AllUsernameViewModel {
    private List<String> usernames;


    public AllUsernameViewModel() {
        this.usernames = new LinkedList<>();
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public AllUsernameViewModel setUsernames(List<String> usernames) {
        this.usernames = usernames;
        return this;
    }

}
