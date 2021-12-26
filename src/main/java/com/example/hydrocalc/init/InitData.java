package com.example.hydrocalc.init;

import com.example.hydrocalc.calculator.DarcyWeisbachEquation;
import com.example.hydrocalc.calculator.PipeCrossSectionAreaInSquareMeters;
import com.example.hydrocalc.model.entities.UserEntity;
import com.example.hydrocalc.model.entities.UserRoleEntity;
import com.example.hydrocalc.model.enums.UserRoleEnum;
import com.example.hydrocalc.services.CalcPipeResultService;
import com.example.hydrocalc.services.UserRoleService;
import com.example.hydrocalc.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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

        boolean userRoleEdited = this.userService.editUsersRoles("Tuser1", UserRoleEnum.ADMIN);
        System.out.println();
        UserEntity tuser1 = this.userService.findUserByUsername("tuser1");
        tuser1.getRoles().stream().forEach(userRoleEntity -> System.out.println(userRoleEntity.getRole().name()));

        userRoleEdited = this.userService.editUsersRoles("Tuser1", UserRoleEnum.USER);
        UserEntity tuser11 = this.userService.findUserByUsername("tuser1");
        System.out.println();
        tuser11.getRoles().stream().forEach(userRoleEntity -> System.out.println(userRoleEntity.getRole().name()));
        System.out.println();
        System.out.println("HELLO HYDROCALCULATOR initialised....");
    }
}
