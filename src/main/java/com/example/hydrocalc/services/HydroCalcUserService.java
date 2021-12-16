package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.UserEntity;
import com.example.hydrocalc.repositrory.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HydroCalcUserService implements UserDetailsService {
    private final UserRepository userRepository;

    public HydroCalcUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> byUsername = this.userRepository.findByUsername(username);
        UserEntity user = byUsername.orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " does not exist!"));
        UserDetails mappedUser = mapToUserDetails(user);
        return mappedUser;
    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {
        List<GrantedAuthority> authorities = userEntity
                .getRoles()
                .stream()
                .map(userRoleEntity -> new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name()))
                .collect(Collectors.toList());
        return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
    }
}
