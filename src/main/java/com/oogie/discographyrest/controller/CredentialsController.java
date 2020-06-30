package com.oogie.discographyrest.controller;

import com.oogie.discographyrest.CredentialsRepository;
import com.oogie.discographyrest.model.CredentialsEntity;
import com.oogie.discographyrest.model.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CredentialsController {
    private final CredentialsRepository repository;

    CredentialsController(CredentialsRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/credentials")
    List<CredentialsEntity> all() {
        return repository.findAll();
    }

    @PostMapping("/credentials")
    CredentialsEntity newCredentials(@RequestBody CredentialsEntity nuCredentials) {
        return repository.save(nuCredentials);
    }

    // Single Item

    @GetMapping("/credentials/{id}")
    CredentialsEntity one(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new CredentialsNotFoundException(id));
    }

    @PutMapping("/credentials/{id}")
    CredentialsEntity replaceCredentials(@RequestBody CredentialsEntity nuCredentials, @PathVariable Integer id) {
        return repository.findById(id).map(credentials -> {
            credentials.setUsername(nuCredentials.getUsername());
            credentials.setPassword(nuCredentials.getPassword());
            credentials.setAffiliation(nuCredentials.getAffiliation());
            return repository.save(credentials);
        }).orElseGet(() -> {
            nuCredentials.setId(id);
            return repository.save(nuCredentials);
        });
    }

    @DeleteMapping("/credentials/{id}")
    ErrorResponse deleteCredentials(@PathVariable Integer id) {
        try {
            repository.deleteById(id);
            return new ErrorResponse();
        } catch (Exception e) {
            String s = formatErrorResponse(e.getMessage(), CredentialsEntity.class);
            return new ErrorResponse(0, s);
        }
    }

    private String formatErrorResponse(String s, Class c) {
        return s;
    }
}
