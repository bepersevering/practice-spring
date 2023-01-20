package com.mingshashan.practice.spring.ioc.denpendency.source;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
@Configuration
@PropertySource(value = "META-INF/default.properties", encoding = "UTF-8")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${custom.id:0}")
    private Long id;

    @Value("${custom.name}")
    private String name;

    @Value("${custom.resource:classpath://default.properties}")
    private Resource resource;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);

        applicationContext.refresh();

        ExternalConfigurationDependencySourceDemo demo = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);
        System.out.println("demo.id = " + demo.id);
        System.out.println("demo.name = " + demo.name);
        System.out.println("demo.resource = " + demo.resource);

        applicationContext.close();
    }
}
