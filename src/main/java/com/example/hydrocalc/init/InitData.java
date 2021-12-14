package com.example.hydrocalc.init;

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

//        System.out.println();
//        double dinPN10 = PePipeEnum.DN90.getDinPN10();
//        String nominalDiameter = PePipeEnum.DN90.name();
//        System.out.println();
//        CalculatorPipeResults result3 = HydroCalculator.calculatePipe(dinPN10, 10, 0.0004, 50);
//        result3.setPipeNominalDiameter(PePipeEnum.DN90.name()).setNominalPressure(NominalPressure.PN10.name());
//        System.out.println(result3.getTotalLosses());
//        this.calcPipeResultService.addNewResult(result3);
//
//        CalculatorPipeResults res = HydroCalculator.calculatePipe(PePipeEnum.DN110.getDinPN10(), 15, 0.002, 105.25);
//        this.calcPipeResultService.addNewResult(res);
        this.userRoleService.initUserRoles();
        this.userService.initUsers();
        System.out.println("hello java");

    }
}
