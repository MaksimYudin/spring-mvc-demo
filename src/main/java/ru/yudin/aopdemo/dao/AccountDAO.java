package ru.yudin.aopdemo.dao;

import org.springframework.stereotype.Component;
import ru.yudin.aopdemo.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String email;

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println("add account in db");

    }

    public List<Account> findAccounts(boolean simulateException) {

        if (simulateException)
            throw new RuntimeException("bla bla exception");

        List<Account> accounts = new ArrayList<>();

        Account temp1 = new Account("max", 1);
        Account temp2 = new Account("max2", 2);
        Account temp3 = new Account("max3", 3);

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;

    }

    public void doWork() {

        System.out.println("Account DAO doWork()");

    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public String getEmail() {
        System.out.println("getEmail");
        return email;
    }

    public void setEmail(String email) {
        System.out.println("setEmail");
        this.email = email;
    }
}
