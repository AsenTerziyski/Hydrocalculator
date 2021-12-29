package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.entities.UserRoleEntity;
import com.example.hydrocalc.model.enums.UserRoleEnum;
import com.example.hydrocalc.repositrory.UserRoleRepository;
import com.example.hydrocalc.services.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initUserRoles() {
        if (this.userRoleRepository.count() == 0) {
            UserRoleEnum[] roles = UserRoleEnum.values();
            for (UserRoleEnum userRole : roles) {
                String role = userRole.name();

                switch (role.toUpperCase()) {
                    case "USER":
                        UserRoleEntity user = new UserRoleEntity();
                        user.setRole(UserRoleEnum.USER);
                        this.userRoleRepository.save(user);
                        break;
                    case "ADMIN":
                        UserRoleEntity admin = new UserRoleEntity();
                        admin.setRole(UserRoleEnum.ADMIN);
                        this.userRoleRepository.save(admin);
                        break;
                }

            }
        }
    }

    public List<UserRoleEntity> findAllRoles() {
        return this.userRoleRepository.findAll();
    }

    @Override
    public UserRoleEntity findRoleEntityByRole(UserRoleEnum user) {
        UserRoleEntity byRole = this.userRoleRepository.findByRole(user);
        if (byRole != null) {
            return byRole;
        }
        return null;
    }

    @Override
    public UserRoleEntity findRoleByRoleEnum(UserRoleEnum userRoleEnum) {
        UserRoleEntity byRole = this.userRoleRepository.findByRole(userRoleEnum);
        return byRole;
    }
}
