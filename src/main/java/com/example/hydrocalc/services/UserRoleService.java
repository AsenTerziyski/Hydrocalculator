package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.UserRoleEntity;
import com.example.hydrocalc.model.enums.UserRoleEnum;

import java.util.List;

public interface UserRoleService {
    void initUserRoles();

    List<UserRoleEntity> findAllRoles();

    UserRoleEntity findRoleEntityByRole(UserRoleEnum user);

    UserRoleEntity findRoleByRoleEnum(UserRoleEnum userRoleEnum);
}
