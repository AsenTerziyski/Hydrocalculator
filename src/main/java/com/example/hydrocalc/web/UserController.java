package com.example.hydrocalc.web;

import com.example.hydrocalc.model.binding.UserEditBindingModel;
import com.example.hydrocalc.model.binding.UserRegisterBindingModel;
import com.example.hydrocalc.services.UserBrowserService;
import com.example.hydrocalc.services.UserService;
import com.example.hydrocalc.web.exceptions.ObjectNotFoundException;
import com.example.hydrocalc.web.exceptions.UserNotAllowedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;
    private final UserBrowserService userBrowserService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService, UserBrowserService userBrowserService) {
        this.userService = userService;
        this.userBrowserService = userBrowserService;
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

        this.userService.registerNewUserInHydrocalculator(userRegisterBindingModel);
        return "redirect:/";
    }

    @ModelAttribute
    public UserEditBindingModel userEditBindingModel() {
        return new UserEditBindingModel();
    }

    @GetMapping("/users/edit")
    public String getUsersEditPage(Model model, Principal principal) {
        model.addAttribute("allUsernames", this.userService.getAllUsernames(principal));
        if (!model.containsAttribute("itIsYourself")) {
            model.addAttribute("itIsYourself", false);
        }
        return "user-edit";
    }

    @PostMapping("/users/edit/post")
    public String postUsersEdit(@Valid UserEditBindingModel userEditBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Principal principal, Model model, Authentication authentication) {

        boolean roleIsAdmin = authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equalsIgnoreCase("role_admin"));

        if (!roleIsAdmin) {
            throw new UserNotAllowedException(authentication.getName());
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userEditBindingModel", userEditBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userEditBindingModel",
                            bindingResult);
            return "redirect:/users/edit";

        }

        if (principal.getName().equalsIgnoreCase(userEditBindingModel.getUsername())) {
            redirectAttributes.addFlashAttribute("itIsYourself", true);
            return "redirect:/users/edit";
        }

        this.userService.editUserRole(userEditBindingModel.getUsername(), userEditBindingModel.getUserRole());

        this.userService.getUserRolesToString(userEditBindingModel.getUsername());
        model.addAttribute("userId", this.userService.findUserByUsername(userEditBindingModel.getUsername()).getId());
        model.addAttribute("editedUser", this.userService.findUserByUsername(userEditBindingModel.getUsername()));
        model.addAttribute("editedUserRoles", this.userService.getUserRolesToString(userEditBindingModel.getUsername()));
        return "user-profile";

    }

    @DeleteMapping("/user/delete/{id}")
    public String removeCalculation(@PathVariable Long id, Authentication authentication, Model model) {
        boolean hasRoleAdmin = authentication
                .getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equalsIgnoreCase("role_admin"));
        if (hasRoleAdmin) {
            boolean successfullyRemoved = this.userService.removeUser(id);
            if (successfullyRemoved) {
                LOGGER.info("{} deleted user with id {}!", authentication.getName(), id);
                return "successful";
            } else {
                LOGGER.info("Could not find user with ID:{}", id);
                throw new ObjectNotFoundException("user with ID:" + id);
            }
        } else {
            LOGGER.info("{} tried to delete another user!", authentication.getName());
            throw new UserNotAllowedException(authentication.getName());
        }
    }

    @GetMapping("/users/browser")
    public String getUserBrowserPage(Model model) {
        model.addAttribute("usersWhoBrowsed", this.userBrowserService.findAll());
        return "user-browser";
    }
}
