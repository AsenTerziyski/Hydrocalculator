package com.example.hydrocalc.init;

import com.example.hydrocalc.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {
    private final CalcPipeResultService calcPipeResultService;
    private final UserRoleService userRoleService;
    private final UserService userService;
    private final PePipeService pePipeService;
    private final PvcOPipeService pvcOPipeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(InitData.class);

    public InitData(CalcPipeResultService calcPipeResultService, UserRoleService userRoleService, UserService userService, PePipeService pePipeService, PvcOPipeService pvcOPipeService) {
        this.calcPipeResultService = calcPipeResultService;
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.pePipeService = pePipeService;
        this.pvcOPipeService = pvcOPipeService;
    }

    @Override
    public void run(String... args) throws Exception {
        initHydrocalculator();
    }

    private void initHydrocalculator() {
        LOGGER.info("HELLO HYDROCALCULATOR :)");
        this.userRoleService.initUserRoles();
        this.userService.initUsers();
        this.pePipeService.initPePipes();
        this.pvcOPipeService.initPvcOPipes();
        LOGGER.info("HYDROCALCULATOR initialized at {}!", LocalDateTime.now());
    }
}
