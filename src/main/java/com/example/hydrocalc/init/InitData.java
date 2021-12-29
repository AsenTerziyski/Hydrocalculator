package com.example.hydrocalc.init;

import com.example.hydrocalc.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
    private final CalcPipeResultService calcPipeResultService;
    private final UserRoleService userRoleService;
    private final UserService userService;
    private final PePipeService pePipeService;
    private final PvcOPipeService pvcOPipeService;

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
        System.out.println("HELLO HYDROCALCULATOR :)");
        this.userRoleService.initUserRoles();
        this.userService.initUsers();
        this.pePipeService.initPePipes();
        this.pvcOPipeService.initPvcOPipes();
        System.out.println("HYDROCALCULATOR initialised....");
    }
}
