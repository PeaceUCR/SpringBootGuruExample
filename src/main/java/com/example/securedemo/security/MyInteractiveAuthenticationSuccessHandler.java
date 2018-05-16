package com.example.securedemo.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class MyInteractiveAuthenticationSuccessHandler implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent interactiveAuthenticationSuccessEvent) {
        System.out.println("I am interactuve");
        System.out.println(interactiveAuthenticationSuccessEvent.getSource());
    }
}