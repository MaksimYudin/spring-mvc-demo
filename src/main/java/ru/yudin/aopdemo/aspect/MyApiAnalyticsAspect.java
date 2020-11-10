package ru.yudin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("ru.yudin.aopdemo.aspect.AspectUtil.forDAOPackageNoGetterSetter()")
    public void performsAPIAnalytics() {

        System.out.println("====>>> perform API analytics");

    }

}
