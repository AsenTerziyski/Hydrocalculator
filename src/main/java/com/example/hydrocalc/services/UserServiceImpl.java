package com.example.hydrocalc.services;

import com.example.hydrocalc.model.UserEntity;
import com.example.hydrocalc.model.UserRoleEntity;
import com.example.hydrocalc.repositrory.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initUsers() {
        if(this.userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            List<UserRoleEntity> allRoles = this.userRoleService.findAllRoles();

            admin
                    .setFullName("admin admin")
                    .setPassword(this.passwordEncoder.encode("12345"))
                    .setUsername("admin")
                    .setRoles(allRoles);

            UserRoleEntity userRole = allRoles.stream().filter(userRoleEntity -> userRoleEntity.getRole().name().equalsIgnoreCase("user")).findFirst().orElse(null);
            UserEntity user = new UserEntity();
            user
                    .setFullName("test user 1")
                    .setPassword(this.passwordEncoder.encode("12345"))
                    .setUsername("tuser1")
                    .setRoles(List.of(userRole));
            this.userRepository.save(admin);
            this.userRepository.save(user);
        }

    }
}
