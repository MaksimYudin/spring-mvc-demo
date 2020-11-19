package ru.yudin.springdemo.newapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* ru.yudin.springdemo.newapp.controller.*.*(..))")
    public void forControllerPackage() {}

    @Pointcut("execution(* ru.yudin.springdemo.newapp.dao.*.*(..))")
    public void forDAOPackage() {}

    @Pointcut("execution(* ru.yudin.springdemo.newapp.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    public void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=====> @Before: method: " + method);



    }
}
