package com.darashuk.application.appUser.registration;

import lombok.Data;
 
@Data
public class RegistrationRequest {

    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;

}
