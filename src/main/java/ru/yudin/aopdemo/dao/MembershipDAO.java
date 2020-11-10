package ru.yudin.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {

        System.out.println("membership add account");

    }

    public boolean addAccountBool() {

        System.out.println("membership add account");

        return true;

    }

    public void goToSleep() {

        System.out.println("goToSleep() advice");

    }

}
