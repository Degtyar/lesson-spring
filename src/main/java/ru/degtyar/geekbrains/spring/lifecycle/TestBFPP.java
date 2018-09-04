package ru.degtyar.geekbrains.spring.lifecycle;


import org.springframework.beans.BeansException;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import org.springframework.stereotype.Component;

@Component
public class TestBFPP implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("[TestBFPP]");
        for(String name: beanDefinitionNames){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            System.out.println(beanDefinition.toString());
        }
        System.out.println("[TestBFPP - end]");
    }
}