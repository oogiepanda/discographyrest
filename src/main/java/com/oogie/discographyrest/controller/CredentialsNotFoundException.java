package com.oogie.discographyrest.controller;

public class CredentialsNotFoundException extends RuntimeException{
    CredentialsNotFoundException(Integer id) {
        super("Could not find credentials " + id);
    }
}
