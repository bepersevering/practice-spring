package com.mingshashan.practice.spring.bean.factory;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;

public class DefaultUserFactory implements UserFactory {
    @Override
    public User createUser() {
        User user = new User();
        user.setId(2L);
        user.setName("程圣母");
        return user;
    }
}
