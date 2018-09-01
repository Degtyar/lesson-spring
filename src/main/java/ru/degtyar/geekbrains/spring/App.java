package ru.degtyar.geekbrains.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User) appContext.getBean("user");

        System.out.println(user.getName() + "  " + user.getMail());
    }
}
