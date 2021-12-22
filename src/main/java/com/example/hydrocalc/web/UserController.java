package com.example.hydrocalc.web;

import com.example.hydrocalc.model.binding.UserRegisterBindingModel;
import com.example.hydrocalc.model.entities.UserEntity;
import com.example.hydrocalc.services.UserService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String getLoginPage() {
        return "users-login";
    }

    @GetMapping("/logout-page")
    public String getLogoutPage() {
        return "users-logout-page";
    }

    @PostMapping("/users/login-error")
    public String loginFailure(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes attributes) {
        System.out.println();
        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("username", username);
        return "redirect:/users/login";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/users/register")
    public String getRegisterPage(Model model) {
        if (!model.containsAttribute("occupiedUsername")) {
            model.addAttribute("occupiedUsername", false);
        }
        if (!model.containsAttribute("confirmPasswordMatchesPassword")) {
            model.addAttribute("confirmPasswordMatchesPassword", true);
        }
        return "users-register";
    }

    @PostMapping("/users/register/new-user")
    public String registerPost(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()
                || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            model.addAttribute("confirmPasswordMatchesPassword", false);
            return "users-register";
        }

        if (this.userService.findUserByUsername(userRegisterBindingModel.getUsername()) != null) {
            model.addAttribute("occupiedUsername", true);
            return "users-register";
        }

        boolean successfulRegistration = this.userService.registerNewUserInHydrocalculator(userRegisterBindingModel);
        if (successfulRegistration) {
            return "index";
        } else {
            //todo
        }
        return "index";
    }


}
