package com.mingshashan.practice.spring.ioc.denpendency.injection;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class AnnotationDependencySetterInjectionDemo {
    public static void main(String[] args) {
        // 1.BeanFactory容器
        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();
        // 注册Configuration Class(配置类)
        beanFactory.register(AnnotationDependencySetterInjectionDemo.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlClassPath = "classpath:/META-INF/dependency-lookup-context.xml";

        // 加载xml资源，解析并生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlClassPath);
        // 启动Spring上下文
        beanFactory.refresh();

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);

        // 显示关闭spring应用上下文
        beanFactory.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}
