package com.rest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Users;


@RequestMapping("/rest/security")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

	
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/login")
    public String validateLogin() {
        return "Authenticated Successfully...";
    }
    
}
