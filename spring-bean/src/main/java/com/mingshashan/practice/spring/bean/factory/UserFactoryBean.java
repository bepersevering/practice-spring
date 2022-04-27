package com.mingshashan.practice.spring.bean.factory;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link com.mingshashan.practice.spring.ioc.container.overview.domain.User}Bean的{@link org.springframework.beans.factory.FactoryBean}实现
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setId(3L);
        user.setName("章北海");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
