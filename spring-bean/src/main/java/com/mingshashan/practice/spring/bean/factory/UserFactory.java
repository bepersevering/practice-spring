package com.mingshashan.practice.spring.bean.factory;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;

/**
 * user factory
 */
public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }
}
