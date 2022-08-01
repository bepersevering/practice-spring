package com.mingshashan.practice.spring.ioc.denpendency.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link NoUniqueBeanDefinitionException}
 */
public class NoUniqueBeanDefinitionExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 当前类作为配置类
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        try {
            String bean = applicationContext.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException e) {
            e.printStackTrace();
        }
        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public String bean1() {
        return "bean1";
    }

    @Bean
    public String bean2() {
        return "bean2";
    }

}
