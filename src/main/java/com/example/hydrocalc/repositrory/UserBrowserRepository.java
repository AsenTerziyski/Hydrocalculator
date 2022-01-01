package com.example.hydrocalc.repositrory;

import com.example.hydrocalc.model.entities.UserBrowser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserBrowserRepository extends JpaRepository<UserBrowser, Long> {
    UserBrowser findByCreatedAndUsername(LocalDateTime created, String username);
    UserBrowser findByUsername(String username);
    List<UserBrowser> findAllByUsername(String username);
}
