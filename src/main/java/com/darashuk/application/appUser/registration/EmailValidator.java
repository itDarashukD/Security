package com.darashuk.application.appUser.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {


    @Override
    public boolean test(String s) {
        //TODO Email validation regex
        return true;
    }
}
