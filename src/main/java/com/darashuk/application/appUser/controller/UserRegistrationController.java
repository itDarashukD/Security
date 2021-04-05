package com.darashuk.application.appUser.controller;

import com.darashuk.application.appUser.registration.RegistrationRequest;
import com.darashuk.application.appUser.registration.RegistrationService;
import com.darashuk.application.appUser.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/registration")
public class UserRegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);

    }

}
