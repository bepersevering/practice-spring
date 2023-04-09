package com.mingshashan.practice.spring.ioc.denpendency.lookup.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class ProductFactory implements FactoryBean<Product> {
    @Override
    public Product getObject() throws Exception {
        Product product = new Product();
        product.setProductId("1111");
        product.setProductName("哈哈");
        return product;
    }

    @Override
    public Class<?> getObjectType() {
        return Product.class;
    }
}
