package com.mingshashan.practice.spring.bean.definition;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanDefinition demo
 * {@link org.springframework.beans.factory.config.BeanDefinition}
 * {@link org.springframework.beans.factory.support.BeanDefinitionBuilder}
 */
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        // 通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // beanDefinitionBuilder.addPropertyValue("id", 11L);
        // beanDefinitionBuilder.addPropertyValue("name", "三体");
        beanDefinitionBuilder.addPropertyValue("id", 11L).addPropertyValue("name", "大史");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);

        // use GenericBeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        // use MutablePropertyValues set properties
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        // mutablePropertyValues.addPropertyValue("id", 11L);
        // mutablePropertyValues.addPropertyValue("name", "三体");
        mutablePropertyValues.add("id", 21L).add("name", "章北海");

        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();
        beanFactory.register(BeanDefinitionDemo.class);
        beanFactory.registerBeanDefinition(DefaultBeanNameGenerator.INSTANCE.generateBeanName(beanDefinition, beanFactory.getDefaultListableBeanFactory()), beanDefinition);

        beanFactory.refresh();
        lookupByType(beanFactory);
        beanFactory.close();
    }

    private static void lookupByType(BeanFactory factory) {
        User user = factory.getBean(User.class);
        System.out.println("by type: " + user);
    }
}
