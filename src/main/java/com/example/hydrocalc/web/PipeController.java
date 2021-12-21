package com.example.hydrocalc.web;

import com.example.hydrocalc.model.binding.PePipeBindingModel;
import com.example.hydrocalc.model.binding.PipeDIBindingModel;
import com.example.hydrocalc.model.binding.PvcOPipeBindingModel;
import com.example.hydrocalc.model.entities.CalculatorPipeResults;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;
import com.example.hydrocalc.services.CalcPipeResultService;
import com.example.hydrocalc.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class PipeController {
    private final CalcPipeResultService calcPipeResultService;


    public PipeController(CalcPipeResultService calcPipeResultService) {
        this.calcPipeResultService = calcPipeResultService;
    }

    @GetMapping("/calc-pipe-DI")
    public String getCalcPipeByDIPage(Model model) {
        addVelocityAttributesToModelIfTheyDoNotExist(model);
        return "pipe-ID-input";
    }

    private void addVelocityAttributesToModelIfTheyDoNotExist(Model model) {
        if (!model.containsAttribute("highVelocity")) {
            model.addAttribute("highVelocity", false);
        }
        if (!model.containsAttribute("lowVelocity")) {
            model.addAttribute("lowVelocity", false);
        }
    }

    @ModelAttribute
    public PipeDIBindingModel pipeDIBindingModel() {
        return new PipeDIBindingModel();
    }

    @PostMapping("/calc-pipe-DI/post")
    public String postPipeInputByDI(@Valid PipeDIBindingModel pipeDIBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("pipeDIBindingModel", pipeDIBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.pipeDIBindingModel",
                            pipeDIBindingModel);
            return "pipe-ID-input";
        }
        System.out.println();
        Long savedResult = -1L;
        if (principal != null) {
            savedResult = this.calcPipeResultService.calculateByInternalDiameter(pipeDIBindingModel, principal.getName());
        } else {
            savedResult = this.calcPipeResultService.calculateByInternalDiameter(pipeDIBindingModel, null);
        }

        CalculatorPipeResultsModelView resultById = this.calcPipeResultService.findResultById(savedResult);
        model.addAttribute("result", resultById);
        model.addAttribute("resultPePipe", resultById);
        addVelocityAttributesToModel(model, resultById);
        return "pipe-ID-exit";
    }

    private void addVelocityAttributesToModel(Model model, CalculatorPipeResultsModelView resultById) {
        model.addAttribute("highVelocity", resultById.isVelocityHigh());
        model.addAttribute("lowVelocity", resultById.isVelocityLow());
    }

    @GetMapping("/calc-pipe-PE")
    public String getCalcPePipePage(Model model) {
        addVelocityAttributesToModelIfTheyDoNotExist(model);
        return "pipe-PE-input";
    }

    @ModelAttribute
    public PePipeBindingModel pePipeBindingModel() {
        return new PePipeBindingModel();
    }

    @PostMapping("/calc-pipe-PE/post")
    public String postPePipeInput(@Valid PePipeBindingModel pePipeBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("pePipeBindingModel", pePipeBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.pePipeBindingModel",
                            pePipeBindingModel);
            return "pipe-PE-input";
        }

        Long savedResultId = this.calcPipeResultService.calculatePePipe(pePipeBindingModel);
        if (savedResultId < 0L) {
            model.addAttribute("availableDiametersForNominalPressure",
                    this.calcPipeResultService
                            .getAvailableDiametersForPePipes(pePipeBindingModel.getNominalPressure()));
            return "pipe-PE-available-diameters";
        }
        CalculatorPipeResultsModelView resultById = this.calcPipeResultService.findResultById(savedResultId);
        model.addAttribute("resultPePipe", resultById);
        addVelocityAttributesToModel(model, resultById);
        return "pipe-PE-exit";
    }

    @GetMapping("/calc-pipe-PVC-O")
    public String getCalcPvcOPipePage(Model model) {
        addVelocityAttributesToModelIfTheyDoNotExist(model);
        return "pipe-PVC-O-input";
    }

    @ModelAttribute
    public PvcOPipeBindingModel pvcOPipeBindingModel() {
        return new PvcOPipeBindingModel();
    }

    @PostMapping("/calc-pipe-PVC-O/post")
    public String postPvcOPipeInput(@Valid PvcOPipeBindingModel pvcOPipeBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    Model model) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("pePipeBindingModel", pvcOPipeBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.pvcOPipeBindingModel",
                            pvcOPipeBindingModel);
            return "pipe-PVC-O-input";
        }

        Long savedResultId = this.calcPipeResultService.calculatePvcOPipe(pvcOPipeBindingModel);

        if (savedResultId < 0L) {
            String availableDiametersForPvcOPipes = this.calcPipeResultService.getAvailableDiametersForPvcOPipes(pvcOPipeBindingModel.getNominalPressure());
            model.addAttribute("availableDiametersForPvcOPipes", availableDiametersForPvcOPipes);
            return "pipe-PVC-O-available-diameters";
        }

        CalculatorPipeResultsModelView resultById = this.calcPipeResultService.findResultById(savedResultId);
        model.addAttribute("resultPvcOPipe", resultById);
        addVelocityAttributesToModel(model, resultById);
        return "pipe-PVC-O-exit";
    }


}
