package com.mingshashan.practice.spring.ioc.container.overview.container;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * ioc container
 * {@link BeanFactory} 作为IoC容器示例
 */
public class BeanFactoryAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitionsCount = beanDefinitionReader.loadBeanDefinitions(location);
        System.out.printf("bean load count : [%d]\n", beanDefinitionsCount);
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) factory;
            Map<String, User> collection = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupCollectionType: " + collection);
        }
    }
}
