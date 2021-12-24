package com.example.hydrocalc.init;

import com.example.hydrocalc.calculator.PipeCrossSectionAreaInSquareMeters;
import com.example.hydrocalc.services.CalcPipeResultService;
import com.example.hydrocalc.services.UserRoleService;
import com.example.hydrocalc.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        System.out.println("HELLO HYDROCALCULATOR :)");
        this.userRoleService.initUserRoles();
        this.userService.initUsers();
        System.out.println("HELLO HYDROCALCULATOR initialised....");
        PipeCrossSectionAreaInSquareMeters pipeCrossSectionArea = new PipeCrossSectionAreaInSquareMeters(20);
        double crossSectionArea = pipeCrossSectionArea.getCrossSectionArea();
        System.out.println(crossSectionArea);

    }
}
