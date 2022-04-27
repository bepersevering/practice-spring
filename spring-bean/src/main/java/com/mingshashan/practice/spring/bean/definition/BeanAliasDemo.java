package com.mingshashan.practice.spring.bean.definition;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean别名示例
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        lookupByAliasName(beanFactory);
        aliasNameBeanReferenceOriginal(beanFactory);
    }

    private static void aliasNameBeanReferenceOriginal(BeanFactory beanFactory) {
        User alias = (User) beanFactory.getBean("xiaoming");
        System.out.println("by alias name: " + alias);
        User original = (User) beanFactory.getBean("xiaoming");
        System.out.println("by original name: " + original);

        System.out.println("alias 与 original是否相同：" + (alias == original));

    }

    private static void lookupByAliasName(BeanFactory factory) {
        User user = (User) factory.getBean("xiaoming");
        System.out.println("by type: " + user);
    }
}
