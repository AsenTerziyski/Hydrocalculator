package com.example.hydrocalc.web;

import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;
import com.example.hydrocalc.services.CalcPipeResultService;
import com.example.hydrocalc.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOError;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/my-calculations")
public class MyCalculationsController {
    private final UserService userService;
    private final CalcPipeResultService calcPipeResultService;

    public MyCalculationsController(UserService userService, CalcPipeResultService calcPipeResultService) {
        this.userService = userService;
        this.calcPipeResultService = calcPipeResultService;
    }

    @Transactional
    @GetMapping
    public String getMyCalculationsPage(Principal principal, Model model) {
        List<CalculatorPipeResultsModelView> myCalculations = this.userService.findMyCalculations(principal);
        for (CalculatorPipeResultsModelView myCalculation : myCalculations) {
            if (this.calcPipeResultService.isOwnerOrAdmin(principal, myCalculation.getId())) {
                myCalculation.setCanDelete(true);
            }
        }
        model.addAttribute("myCalculations", myCalculations);
        return "my-calculations";
    }

    @DeleteMapping("/remove/{id}")
    public String removeCalculation(@PathVariable Long id, Principal principal, Model model) {
        System.out.println();
        if (this.calcPipeResultService.isOwnerOrAdmin(principal, id)) {
            boolean removed = this.calcPipeResultService.removeCalculation(id);
        } else {
            //todo
        }
        return "redirect:/my-calculations";
    }
}
