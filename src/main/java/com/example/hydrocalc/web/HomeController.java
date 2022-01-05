package com.example.hydrocalc.web;

import com.example.hydrocalc.services.PePipeService;
import com.example.hydrocalc.services.PpPipeService;
import com.example.hydrocalc.services.PvcOPipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final PePipeService pePipeService;
    private final PvcOPipeService pvcOPipeService;
    private final PpPipeService ppPipeService;

    public HomeController(PePipeService pePipeService, PvcOPipeService pvcOPipeService, PpPipeService ppPipeService) {
        this.pePipeService = pePipeService;
        this.pvcOPipeService = pvcOPipeService;
        this.ppPipeService = ppPipeService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/catalog")
    public String getPipeCatalog(Model model) {
        model.addAttribute("PE", this.pePipeService.getPeCatalog());
        model.addAttribute("PVCo", this.pvcOPipeService.getPvcoCatalog());
        model.addAttribute("PP", this.ppPipeService.getPpCatalog());
        return "catalog";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

}
