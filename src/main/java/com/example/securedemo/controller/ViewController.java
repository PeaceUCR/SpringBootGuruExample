package com.example.securedemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/mylogin", method = RequestMethod.GET)
    public String mylogin(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("<--Current User-->");
        System.out.println(auth.getPrincipal());
        System.out.println(auth.getCredentials());
        System.out.println(auth.getAuthorities());
        System.out.println(auth.getDetails());
        return "mylogin";
    }
}
