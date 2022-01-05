package com.example.hydrocalc.web;

import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;
import com.example.hydrocalc.services.CalcPipeResultService;
import com.example.hydrocalc.services.UserService;
import com.example.hydrocalc.web.exceptions.UserNotAllowedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


//    @Transactional
    @GetMapping
    public String getMyCalculationsPage(Principal principal, Model model) {
        List<CalculatorPipeResultsModelView> myCalculations = this.userService.findMyCalculations(principal);

        for (CalculatorPipeResultsModelView myCalculation : myCalculations) {
            if (this.calcPipeResultService.isOwnerOrAdmin(principal, myCalculation.getId())) {
                myCalculation.setCanDelete(true);
            }
        }
        if (myCalculations.size()==0) {
            model.addAttribute("noCalculations", true);
        } else {
            model.addAttribute("noCalculations", false);
        }
        model.addAttribute("myCalculations", myCalculations);

        return "my-calculations";
    }

    @DeleteMapping("/remove/{id}")
    public String removeCalculation(@PathVariable Long id, Principal principal, Model model) {
        if (this.calcPipeResultService.isOwnerOrAdmin(principal, id)) {
            boolean removed = this.calcPipeResultService.removeCalculation(id);
            return "redirect:/my-calculations";
        } else {
            throw new UserNotAllowedException(principal.getName());
        }
    }
}
