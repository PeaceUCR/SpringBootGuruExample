package com.example.securedemo.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

import org.springframework.stereotype.Component;


@Component
public class MyAuthenticationSuccessHandler implements ApplicationListener<AuthenticationSuccessEvent> {


    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        System.out.println("I am authen");
        System.out.println(authenticationSuccessEvent.getSource());
    }
}
