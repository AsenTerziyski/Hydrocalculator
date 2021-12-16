package com.example.hydrocalc.web;

import com.example.hydrocalc.model.binding.PipeDIBindingModel;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;
import com.example.hydrocalc.services.CalcPipeResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PipeController {
    private final CalcPipeResultService calcPipeResultService;

    public PipeController(CalcPipeResultService calcPipeResultService) {
        this.calcPipeResultService = calcPipeResultService;
    }

    @GetMapping("/calc-pipe-DI")
    public String getCalcPipeByDIPage() {
        return "pipe-ID-input";
    }

    @ModelAttribute
    public PipeDIBindingModel pipeDIBindingModel() {
        return new PipeDIBindingModel();
    }

    @PostMapping("/calc-pipe-DI/post")
    public String postPipeInputByDI(@Valid PipeDIBindingModel inputByInternalDiameter,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("pipeDIBindingModel", inputByInternalDiameter)
                    .addFlashAttribute("org.springframework.validation.BindingResult.pricesEditBindingModel",
                            inputByInternalDiameter);
            return "pipe-ID-input";
        }

        Long savedResult = this.calcPipeResultService.calculateByInternalDiameter(inputByInternalDiameter);
        CalculatorPipeResultsModelView resultById = this.calcPipeResultService.findResultById(savedResult);
        System.out.println();
        model.addAttribute("result", resultById);

        return "pipe-ID-exit";
    }


}
