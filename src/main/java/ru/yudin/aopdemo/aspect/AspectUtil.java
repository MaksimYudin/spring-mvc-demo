package ru.yudin.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AspectUtil {

    @Pointcut("execution(* ru.yudin.aopdemo.dao.*.*(..))")
    public void forDAOPackage() {}

    @Pointcut("execution(* ru.yudin.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* ru.yudin.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter() {}

}
