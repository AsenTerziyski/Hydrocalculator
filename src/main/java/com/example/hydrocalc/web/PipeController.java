package com.example.hydrocalc.web;

import com.example.hydrocalc.model.binding.*;
import com.example.hydrocalc.model.view.CalculatorPipeResultsModelView;
import com.example.hydrocalc.services.CalcPipeResultService;
import com.example.hydrocalc.services.UserService;
import com.example.hydrocalc.web.exceptions.UserNotAllowedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Locale;
import java.util.Set;

@Controller
public class PipeController {
    private final CalcPipeResultService calcPipeResultService;
    private final UserService userService;


    public PipeController(CalcPipeResultService calcPipeResultService, UserService userService) {
        this.calcPipeResultService = calcPipeResultService;
        this.userService = userService;
    }

    @GetMapping("/calc-pipe-DI")
    public String getCalcPipeByDIPage(Model model) {
        addVelocityAttributesToModelIfTheyDoNotExist(model);
        Set<String> temperatureSet = this.calcPipeResultService.getTemperatureSet();
        model.addAttribute("waterTemperatures", temperatureSet);
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
                            bindingResult);
            return "redirect:/calc-pipe-DI";
        }
        Long savedResult = -1L;
        if (principal != null) {
            savedResult = this.calcPipeResultService.calculateByInternalDiameter(pipeDIBindingModel, principal.getName());
        } else {
            //todo -> throw
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
        Set<String> temperatureSet = this.calcPipeResultService.getTemperatureSet();
        model.addAttribute("waterTemperatures", temperatureSet);
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
                                  Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("pePipeBindingModel", pePipeBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.pePipeBindingModel",
                            bindingResult);
            return "redirect:/calc-pipe-PE";
        }

        Long savedResultId = -1L;
        if (principal != null) {
            savedResultId = this.calcPipeResultService.calculatePePipe(pePipeBindingModel, principal.getName());
        } else {
            //todo -> throw
            savedResultId = this.calcPipeResultService.calculatePePipe(pePipeBindingModel, null);
        }

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
        Set<String> temperatureSet = this.calcPipeResultService.getTemperatureSet();
        model.addAttribute("waterTemperatures", temperatureSet);
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
                                    Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("pvcOPipeBindingModel", pvcOPipeBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.pvcOPipeBindingModel", bindingResult);
            return "redirect:/calc-pipe-PVC-O";
        }

        Long savedResultId = -1L;
        if (principal != null) {
            savedResultId = this.calcPipeResultService.calculatePvcOPipe(pvcOPipeBindingModel, principal.getName());
        } else {
            throw new UserNotAllowedException("ANONYMOUS");
        }

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

    @GetMapping("/pipes/edit-di")
    public String getPipeEditIDPage() {
        return "pipe-edit-ID";
    }

    @ModelAttribute
    public PipeEditInternalDiameterBindingModel pipeEditInternalDiameterBindingModel() {
        return new PipeEditInternalDiameterBindingModel();
    }

    @GetMapping("/unsuccessful")
    public String getUnsuccessfulPage() {
        return "unsuccessful";
    }

    @PostMapping("/pipes/edit-di")
    public String postPipeEdit(@Valid PipeEditInternalDiameterBindingModel pipeEditInternalDiameterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("pipeEditInternalDiameterBindingModel", pipeEditInternalDiameterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.pipeEditInternalDiameterBindingModel",
                            bindingResult);
            return "redirect:/pipes/edit-di";
        }

        if (principal != null) {
            boolean successful = this.userService.editPipeDI(pipeEditInternalDiameterBindingModel);
            if (successful) {
                return "redirect:/catalog";
            } else {
                return "redirect:/unsuccessful";
            }
        } else {
            throw new UserNotAllowedException("ANONYMOUS");
        }
    }

    @ModelAttribute
    public PpPipeBindingModel ppPipeBindingModel() {
        return new PpPipeBindingModel();
    }

    @GetMapping("/calc-pipe-PP")
    public String getCalcPpPipePage(Model model) {
        addVelocityAttributesToModelIfTheyDoNotExist(model);
        Set<String> temperatureSet = this.calcPipeResultService.getTemperatureSet();
        model.addAttribute("waterTemperatures", temperatureSet);
        return "pipe-PP-input";
    }

    @PostMapping("/calc-pipe-PP/post")
    public String postPvcOPipeInput(@Valid PpPipeBindingModel ppPipeBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("ppPipeBindingModel", ppPipeBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.ppPipeBindingModel", bindingResult);
            return "redirect:/calc-pipe-PP";
        }

        Long savedResultId = -1L;
        if (principal != null) {
            savedResultId = this.calcPipeResultService.calculatePpPipe(ppPipeBindingModel, principal.getName());
        } else {
            throw new UserNotAllowedException("ANONYMOUS");
        }

        System.out.println();
        if (savedResultId < 0L) {
            String availableDiametersForPpPipes = this.calcPipeResultService.getAvailableDiametersForPpPipes(ppPipeBindingModel.getNominalPressure());
            model.addAttribute("availableDiametersForPpPipes", availableDiametersForPpPipes);
            return "pipe-PP-available-diameters";
        }
        CalculatorPipeResultsModelView resultById = this.calcPipeResultService.findResultById(savedResultId);
        model.addAttribute("resultPpPipe", resultById);
        addVelocityAttributesToModel(model, resultById);
        return "pipe-PP-exit";
    }



}
