package com.darashuk.application.appUser.registration;

import com.darashuk.application.appUser.AppUser;
import com.darashuk.application.appUser.AppUserRole;
import com.darashuk.application.appUser.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    //получение данных из запроса(из постмана)
    public String register(RegistrationRequest request) {
        boolean isEmailValid = emailValidator.test(request.getEmail());
        if (!isEmailValid) {
            throw new IllegalStateException("Email do not valid");
        }

        return appUserService.signUpUser(new AppUser(
                request.getFirstname(),
                request.getLastname(),
                request.getPassword(),
                request.getEmail(),
                AppUserRole.USER
        ));
    }
}
