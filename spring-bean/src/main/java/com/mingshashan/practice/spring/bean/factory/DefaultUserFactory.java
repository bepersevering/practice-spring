package com.mingshashan.practice.spring.bean.factory;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
    @Override
    public User createUser() {
        User user = new User();
        user.setId(2L);
        user.setName("程圣母");
        return user;
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : UserFactory 初始化中...");
    }

    public void initUserFactory() {
        System.out.println("initUserFactory : UserFactory 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() : UserFactory 初始化中...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy: UserFactory 销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("@DisposableBean: UserFactory 销毁中...");
    }


    public void destroyUserFactory() {
        System.out.println("destroyUserFactory : UserFactory 初始化中...");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize : UserFactory finalize...");
        super.finalize();
    }
}
