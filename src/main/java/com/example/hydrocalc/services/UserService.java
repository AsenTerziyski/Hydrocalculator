package com.example.hydrocalc.services;

import com.example.hydrocalc.model.entities.CalculatorPipeResults;
import com.example.hydrocalc.model.entities.UserEntity;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;

import java.security.Principal;
import java.util.List;

public interface UserService {
    void initUsers();

    UserEntity findUserByUsername(String username);

    List<CalculatorPipeResultsModelView> findMyCalculations(Principal principal);


    boolean userIsAdmin(UserEntity caller);
}
