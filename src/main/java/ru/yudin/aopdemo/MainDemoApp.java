package ru.yudin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.yudin.aopdemo.dao.AccountDAO;
import ru.yudin.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account myAccount = new Account();
        myAccount.setName("blabla");
        myAccount.setLevel(111);

        accountDAO.setName("max");
        accountDAO.setEmail("yudin");

        accountDAO.addAccount(myAccount, true);

        String name = accountDAO.getName();
        String email = accountDAO.getEmail();

        accountDAO.doWork();

        membershipDAO.addAccount();
        membershipDAO.goToSleep();

        context.close();

    }

}
