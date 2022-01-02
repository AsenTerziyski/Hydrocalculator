package com.example.hydrocalc.web;

import com.example.hydrocalc.model.entities.UserBrowser;
import com.example.hydrocalc.services.UserBrowserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Locale;

@Component
public class HydrocalculatorEventListener {
    private final UserBrowserService userBrowserService;
    private static final Logger LOGGER = LoggerFactory.getLogger(HydrocalculatorEventListener.class);

    public HydrocalculatorEventListener(UserBrowserService userBrowserService) {
        this.userBrowserService = userBrowserService;
    }

    @EventListener(ServletRequestHandledEvent.class)
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        String userName = event.getUserName();
        String clientAddress = event.getClientAddress();
        if (userName == null) {
            userName = "ANONYMOUS";
        } else {
            userName = userName.toUpperCase(Locale.ROOT);
        }

        LOGGER.info("User: {} is browsing!! Time: {}", userName, Instant.now());
        LOGGER.info("Client address: {}", clientAddress);
        UserBrowser userBrowser = new UserBrowser();
        userBrowser.setUsername(userName);
        userBrowser.setCreated(LocalDateTime.now());
        userBrowser.setModified(LocalDateTime.now());
        userBrowser.setClientsAddress(clientAddress);
        this.userBrowserService.registerUser(userBrowser);
    }


}
