package com.mingshashan.practice.spring.ioc.denpendency.source;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                beanFactory.registerResolvableDependency(String.class, "Hello World!");
            }
        });

        applicationContext.refresh();
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        /**
         if (beanFactory instanceof ConfigurableListableBeanFactory) {
         ConfigurableListableBeanFactory configurableListableBeanFactory = ConfigurableListableBeanFactory.class.cast(beanFactory);

         configurableListableBeanFactory.registerResolvableDependency(String.class, "Hello World!");
         }
         */

        applicationContext.close();
    }
}
