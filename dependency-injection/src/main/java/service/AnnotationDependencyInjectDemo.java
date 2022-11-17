package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;

public class AnnotationDependencyInjectDemo {

    @Autowired
    List<OtAchWtrDataService> otAchWtrDataServiceList;

    public static void main(String[] args) {
        // 1.BeanFactory容器
        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();
        // 注册Configuration Class(配置类)
        beanFactory.register(AnnotationDependencyInjectDemo.class);
        beanFactory.scan("service");
        // 启动Spring上下文
        beanFactory.refresh();
        AnnotationDependencyInjectDemo demo = beanFactory.getBean(AnnotationDependencyInjectDemo.class);

        Optional.ofNullable(demo.otAchWtrDataServiceList).ifPresent(list -> list.forEach(item -> {
            item.addNewData();
        }));

        // 显示关闭spring应用上下文
        beanFactory.close();
    }
}
