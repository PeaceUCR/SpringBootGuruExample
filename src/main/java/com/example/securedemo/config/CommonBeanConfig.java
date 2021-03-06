package com.example.securedemo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfig {

    @Bean
    public PasswordEncoder strongEncryptor(){
        PasswordEncoder encryptor = new BCryptPasswordEncoder();
        return encryptor;
    }
}
