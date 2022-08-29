package com.mingshashan.practice.spring.ioc.denpendency.injection;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired
    private User user;

    public static void main(String[] args) {
        // 1.BeanFactory容器
        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();
        // 注册Configuration Class(配置类)
        beanFactory.register(AnnotationDependencyInjectionResolutionDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlClassPath = "classpath:/META-INF/dependency-lookup-context.xml";

        // 加载xml资源，解析并生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlClassPath);
        // 启动Spring上下文
        beanFactory.refresh();
        AnnotationDependencyInjectionResolutionDemo demo = beanFactory.getBean(AnnotationDependencyInjectionResolutionDemo.class);
        System.out.println("demo.user: " + demo.user);

        // 显示关闭spring应用上下文
        beanFactory.close();
    }
}
