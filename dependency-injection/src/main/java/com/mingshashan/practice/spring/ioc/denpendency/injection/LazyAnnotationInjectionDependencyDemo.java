package com.mingshashan.practice.spring.ioc.denpendency.injection;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;
import java.util.stream.Collectors;

public class LazyAnnotationInjectionDependencyDemo {

    @Autowired
    private User user;

    @Autowired
    private ObjectProvider<Set<User>> userObjectProvider;

    @Autowired
    private ObjectFactory<Set<User>> userObjectFactory;

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册Configuration Class(配置类) -> Spring Bean
        applicationContext.register(LazyAnnotationInjectionDependencyDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlClassPath = "META-INF/dependency-lookup-context.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlClassPath);

        // 启动Spring应用上下文
        applicationContext.refresh();
        LazyAnnotationInjectionDependencyDemo demo = applicationContext.getBean(LazyAnnotationInjectionDependencyDemo.class);

        System.out.println("user: " + demo.user);
        System.out.println("userObjectProvider: " + demo.userObjectProvider.getObject());
        System.out.println("userObjectFactory: " + demo.userObjectFactory.getObject());

        demo.userObjectProvider.forEach(System.out::println);
        // 关闭Spring应用上下文
        applicationContext.close();
    }
}
