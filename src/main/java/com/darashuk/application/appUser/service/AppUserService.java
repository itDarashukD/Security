package com.darashuk.application.appUser.service;

import com.darashuk.application.appUser.AppUser;
import com.darashuk.application.appUser.registration.RegistrationRequest;
import com.darashuk.application.appUser.repositoty.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final String USER_NOT_FOUND_MSG ="user with %s email not found";
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public String signUpUser(AppUser appUser){

        final boolean isUserExists = userRepository.findByEmail(appUser.getEmail())
                .isPresent();
        if (isUserExists) {throw new IllegalStateException("Email already taken");

        }
        //метод кодировки пароля
        String encodePassword = bCryptPasswordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodePassword);
        userRepository.save(appUser);


        //TODO:sent confirmation token
        return "it works";
    }

}
