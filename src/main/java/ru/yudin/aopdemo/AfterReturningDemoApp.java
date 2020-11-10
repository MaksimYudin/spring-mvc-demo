package ru.yudin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.yudin.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = accountDAO.findAccounts(false);

        System.out.println("After returning");
        System.out.println(accounts);

        context.close();

    }

}
