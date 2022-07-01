package com.mingshashan.practice.spring.ioc.denpendency.lookup;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TypeSafetyDependencyLookupDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 当前类作为配置类
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        displayBeanFactoryGetBean(applicationContext);
        displayObjectFactoryGetObject(applicationContext);

        displayObjectProviderGetObject(applicationContext);
        displayListableBeanFactory(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    private static void displayListableBeanFactory(AnnotationConfigApplicationContext applicationContext) {
        printBeansException("displayListableBeanFactory", () -> applicationContext.getBeansOfType(User.class));
    }


    public static void displayObjectProviderGetObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderGetObject", () -> userObjectProvider.getIfAvailable());
    }

    public static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectFactory<User> userObjectFactory = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject", () -> userObjectFactory.getObject());
    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printBeansException("displayBeanFactoryGetBean", () -> beanFactory.getBean(User.class));
    }

    private static void printBeansException(String source, Runnable runnable) {
        System.err.println("Source form : " + source);
        try {
            runnable.run();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
