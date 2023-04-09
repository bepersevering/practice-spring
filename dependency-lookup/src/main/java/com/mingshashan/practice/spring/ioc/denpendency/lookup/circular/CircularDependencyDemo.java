package com.mingshashan.practice.spring.ioc.denpendency.lookup.circular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependencyDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CircularDependencyDemo.class);
        String basePackage = CircularDependencyDemo.class.getPackage().getName();
        applicationContext.scan(basePackage);
        applicationContext.refresh();
        lookupByType(applicationContext);

        applicationContext.close();
    }

    private static void lookupByType(AnnotationConfigApplicationContext applicationContext) {
        IServiceA serviceA = applicationContext.getBean(IServiceA.class);
        serviceA.aService();
        IServiceB serviceB = applicationContext.getBean(IServiceB.class);
        serviceB.bService();
    }
}
