package com.mingshashan.practice.spring.ioc.denpendency.injection;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collection;

public class CollectionAnnotationInjectionDependencyDemo {

    @Autowired
    private Collection<User> userCollection;

    @Autowired
    private User[] users;

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册Configuration Class(配置类) -> Spring Bean
        applicationContext.register(CollectionAnnotationInjectionDependencyDemo.class);

//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
//        String xmlClassPath = "META-INF/dependency-lookup-context.xml";
//        xmlBeanDefinitionReader.loadBeanDefinitions(xmlClassPath);

        // 启动Spring应用上下文
        applicationContext.refresh();
        CollectionAnnotationInjectionDependencyDemo demo = applicationContext.getBean(CollectionAnnotationInjectionDependencyDemo.class);

        System.out.println(demo.userCollection);
        System.out.println(Arrays.toString(demo.users));

        // 关闭Spring应用上下文
        applicationContext.close();
    }

    @Bean
    public User user1() {
        return User.createUser(1L);
    }

    @Bean
    public User user2() {
        return User.createUser(2L);
    }

    @Bean
    public User user3() {
        return User.createUser(3L);
    }
}
