package com.example.hydrocalc.repositrory;

import com.example.hydrocalc.model.entities.UserRoleEntity;
import com.example.hydrocalc.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    UserRoleEntity findByRole(UserRoleEnum role);
}
