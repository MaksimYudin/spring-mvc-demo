package ru.yudin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingCloud {

    @Before("ru.yudin.aopdemo.aspect.AspectUtil.forDAOPackageNoGetterSetter()")
    public void loggingCloud() {

        System.out.println("====>>> logging cloud");

    }

}
