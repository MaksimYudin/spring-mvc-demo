package ru.yudin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.yudin.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;
        try {
            boolean simulateException = true;
            accounts = accountDAO.findAccounts(simulateException);
        } catch (Exception exc) {
            System.out.println("main app exception: " + exc);
        }

        System.out.println("After returning");
        System.out.println(accounts);

        context.close();

    }

}
