package ru.degtyar.geekbrains.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.degtyar.geekbrains.spring.configuration.ApplicationConfiguration;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        //Camera camera = appContext.getBean("camera",Camera.class);
        //camera.doPhotograph();
    }
}
