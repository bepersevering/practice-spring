package com.mingshashan.practice.spring.ioc.denpendency.lookup.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductBeanFactoryTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/factory-bean.xml");

        Product product = (Product) applicationContext.getBean("productFactory");
        System.out.println(product);
    }
}
