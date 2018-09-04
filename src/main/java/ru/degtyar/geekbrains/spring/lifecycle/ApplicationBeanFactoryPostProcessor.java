package ru.degtyar.geekbrains.spring.lifecycle;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("[BeanFactoryPostProcessor]");
        final String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for(String name: beanDefinitionNames){

            final BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            final String className = beanDefinition.getBeanClassName();
            System.out.println(name + " " + className);
        }
        System.out.println();

    }

}