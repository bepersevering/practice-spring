package com.mingshashan.practice.spring.ioc.denpendency.injection;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierAnnotationInjectionDependencyDemo {

    @Autowired
    @Qualifier("user")
    private User user;

    @Autowired
    private User superUser;



    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册Configuration Class(配置类) -> Spring Bean
        applicationContext.register(QualifierAnnotationInjectionDependencyDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlClassPath = "META-INF/dependency-lookup-context.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlClassPath);

        // 启动Spring应用上下文
        applicationContext.refresh();

        // 关闭Spring应用上下文
        applicationContext.close();
    }



}
