package com.mingshashan.practice.spring.ioc.denpendency.lookup.circular.impl;

import com.mingshashan.practice.spring.ioc.denpendency.lookup.circular.IServiceA;
import com.mingshashan.practice.spring.ioc.denpendency.lookup.circular.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceB implements IServiceB {

    @Autowired
    private IServiceA serviceA;

    @Override
    public void bService() {
        System.out.println("B Service");
    }
}
