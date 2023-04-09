package com.mingshashan.practice.spring.ioc.denpendency.lookup.circular.impl;

import com.mingshashan.practice.spring.ioc.denpendency.lookup.circular.IServiceA;
import com.mingshashan.practice.spring.ioc.denpendency.lookup.circular.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceA implements IServiceA {

    @Autowired
    private IServiceB serviceB;

    @Override
    public void aService() {
        System.out.println("A Service");
    }


}
