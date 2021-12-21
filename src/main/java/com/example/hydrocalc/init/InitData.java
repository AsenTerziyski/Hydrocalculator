package com.example.hydrocalc.init;

import com.example.hydrocalc.services.CalcPipeResultService;
import com.example.hydrocalc.services.UserRoleService;
import com.example.hydrocalc.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InitData implements CommandLineRunner {
    private final CalcPipeResultService calcPipeResultService;
    private final UserRoleService userRoleService;
    private final UserService userService;

    public InitData(CalcPipeResultService calcPipeResultService, UserRoleService userRoleService, UserService userService) {
        this.calcPipeResultService = calcPipeResultService;
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRoleService.initUserRoles();
        this.userService.initUsers();
        System.out.println("HELLO HYDRO CALCULATOR :)");

    }
}
