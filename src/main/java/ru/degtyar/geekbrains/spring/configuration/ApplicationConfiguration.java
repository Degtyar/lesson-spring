package ru.degtyar.geekbrains.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("ru.degtyar.geekbrains.spring")
@EnableJpaRepositories("ru.degtyar.geekbrains.spring.repository")
@Import(DataSourceConfiguration.class)
public class ApplicationConfiguration {


}
