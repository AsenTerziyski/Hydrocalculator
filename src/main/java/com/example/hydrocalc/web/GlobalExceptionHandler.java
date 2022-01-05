package com.example.hydrocalc.web;


import com.example.hydrocalc.web.exceptions.ObjectNotFoundException;
import com.example.hydrocalc.web.exceptions.UserNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotAllowedException.class)
    public ModelAndView handleUserNotAllowedExceptions(UserNotAllowedException e) {
        ModelAndView modelAndView = new ModelAndView("exceptionUserNotAllowed");
        modelAndView.addObject("username", e.getUsername());
        modelAndView.setStatus(HttpStatus.UNAUTHORIZED);
        return modelAndView;
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView handleObjectNotFoundException(ObjectNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("exceptionObjectNotFound");
        modelAndView.addObject("notFound", exception.getText());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }

}
