package com.example.hydrocalc.services.impl;

import com.example.hydrocalc.model.entities.UserBrowser;
import com.example.hydrocalc.repositrory.UserBrowserRepository;
import com.example.hydrocalc.services.UserBrowserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserBrowserServiceImpl implements UserBrowserService {
    private final UserBrowserRepository userBrowserRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBrowserServiceImpl.class);

    public UserBrowserServiceImpl(UserBrowserRepository userBrowserRepository) {
        this.userBrowserRepository = userBrowserRepository;
    }

    @Override
    public void registerUser(UserBrowser userBrowser) {
        Optional<UserBrowser> byCreatedAndUsername = this.userBrowserRepository.findAllByUsername(userBrowser.getUsername()).stream()
                .filter(u -> {
                    Month month = u.getCreated().getMonth();
                    int dayOfMonth = u.getCreated().getDayOfMonth();
                    int year = u.getCreated().getYear();
                    return month.equals(LocalDateTime.now().getMonth()) && dayOfMonth == LocalDateTime.now().getDayOfMonth() && year == LocalDateTime.now().getYear();
                }).findFirst();
        if (byCreatedAndUsername.isPresent()) {
            int dayOfMonth = byCreatedAndUsername.get().getCreated().getDayOfMonth();
            int year = byCreatedAndUsername.get().getCreated().getYear();
            Month month = byCreatedAndUsername.get().getCreated().getMonth();
            String username = byCreatedAndUsername.get().getUsername();
            if (dayOfMonth == userBrowser.getCreated().getDayOfMonth()) {
                if (year == userBrowser.getCreated().getYear()) {
                    if (month.equals(userBrowser.getCreated().getMonth())) {
                        if (username.equalsIgnoreCase(userBrowser.getUsername())) {
                            return;
                        }
                    }
                }
            }
        }
        this.userBrowserRepository.save(userBrowser);
    }

    @Override
    public List<UserBrowser> findAll() {
        return this.userBrowserRepository.findAll();
    }

    @Override
    @Scheduled(cron = "0 0 0 1 1 *")
    public void deleteBrowsingHistory() {
        if (this.userBrowserRepository.count() > 0){
            this.userBrowserRepository.deleteAll();
            LOGGER.info("Deleted browsing history!");
        }
        LOGGER.info("Nothing to delete!");
    }
}
