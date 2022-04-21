package com.mingshashan.practice.spring.ioc.container.overview.dependency.injection;

import com.mingshashan.practice.spring.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        UserRepository userRepository = (UserRepository) factory.getBean("userRepository");
        System.out.println(userRepository.getUsers());
    }
}
