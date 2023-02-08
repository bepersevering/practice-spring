package com.mingshashan.practice.spring.ioc.scope;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class BeanScopeDemo {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    private User singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    private User prototypeUser() {
        return createUser();
    }

    private User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BeanScopeDemo.class);
        applicationContext.refresh();

        scopeBeanByLookup(applicationContext);

        applicationContext.close();
    }

    private static void scopeBeanByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            User singletonUser = applicationContext.getBean("singletonUser", User.class);
            System.out.println("Singleton User = " + singletonUser);

            User prototypeUser = applicationContext.getBean("prototypeUser", User.class);
            System.out.println("Prototype User = " + prototypeUser);
        }
    }
}
