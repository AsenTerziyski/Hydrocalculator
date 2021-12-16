package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.UserRoleEntity;

import java.util.List;

public interface UserRoleService {
    void initUserRoles();

    List<UserRoleEntity> findAllRoles();
}
