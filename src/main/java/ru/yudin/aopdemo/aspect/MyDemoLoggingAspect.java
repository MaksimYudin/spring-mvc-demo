package ru.yudin.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.yudin.aopdemo.Account;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Around("execution(* ru.yudin.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("execute @Around in " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc) {
            System.out.println(exc);

            throw exc;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("duration: " + duration);

        return result;
    }

    @After("execution(* ru.yudin.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyfindAccountException(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();

        System.out.println("after finally exception: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* ru.yudin.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingfindAccountException(JoinPoint joinPoint, Throwable theExc) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println(method);

        System.out.println("after throwing exception: " + theExc);

    }

    @AfterReturning(
            pointcut = "execution(* ru.yudin.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAspect(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println(method);

        System.out.println(result);

        convertNameToUppercase(result);

        System.out.println(result);

    }

    private void convertNameToUppercase(List<Account> result) {

        for (Account account : result) {

            account.setName(account.getName().toUpperCase());

        }

    }


    //@Before("execution(public void ru.yudin.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(ru.yudin.aopdemo.Account))")
    //@Before("execution(* add*(ru.yudin.aopdemo.Account, ..))") // .. is any count of argument
    //@Before("execution(* ru.yudin.aopdemo..dao.*.*(..))")
    @Before("ru.yudin.aopdemo.aspect.AspectUtil.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("====>>> befor execution addAccount");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {

            if (tempArg instanceof Account) {

                Account account = (Account) tempArg;
                System.out.println(account.getName());
                System.out.println(account.getLevel());

            }

        }

    }





}
