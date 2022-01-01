package com.example.hydrocalc.web;

import com.example.hydrocalc.model.entities.UserBrowser;
import com.example.hydrocalc.model.entities.UserEntity;
import com.example.hydrocalc.services.UserBrowserService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import java.time.LocalDateTime;
import java.util.Locale;

@Component
public class HydrocalculatorEventListener {
    private final UserBrowserService userBrowserService;

    public HydrocalculatorEventListener(UserBrowserService userBrowserService) {
        this.userBrowserService = userBrowserService;
    }

    @EventListener(ServletRequestHandledEvent.class)
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        String userName = event.getUserName();
        if (userName == null || userName.isBlank()) {
            userName = "ANONYMOUS";
        } else {
            userName = userName.toUpperCase(Locale.ROOT);
        }
        UserBrowser userBrowser = new UserBrowser();
        userBrowser.setUsername(userName);
        userBrowser.setCreated(LocalDateTime.now());
        userBrowser.setModified(LocalDateTime.now());
        this.userBrowserService.registerUser(userBrowser);



    }


}
