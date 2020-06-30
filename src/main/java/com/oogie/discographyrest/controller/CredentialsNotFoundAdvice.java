package com.oogie.discographyrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.security.auth.login.CredentialNotFoundException;

@ControllerAdvice
public class CredentialsNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CredentialNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(CredentialNotFoundException ex) {
        return ex.getMessage();
    }
}
