package com.example.hydrocalc.model.binding;

import com.example.hydrocalc.model.enums.UserRoleEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserEditBindingModel {
    private String username;
    private UserRoleEnum userRole;

    @Size(min = 5, max = 10)
    public String getUsername() {
        return username;
    }

    public UserEditBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Enumerated
    @NotNull
    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public UserEditBindingModel setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}
