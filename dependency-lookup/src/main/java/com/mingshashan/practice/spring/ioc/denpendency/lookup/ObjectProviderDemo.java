package com.mingshashan.practice.spring.ioc.denpendency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

        lookupByObjectProvider(applicationContext);
        applicationContext.close();
    }

    @Bean
    public String hello() {
        return "Hello";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);

        System.out.printf(objectProvider.getObject());
    }
}