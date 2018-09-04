package ru.degtyar.geekbrains.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "user")
    public User user(){
        return new User("Vasiliy", "mail@example.com");
    }
}
