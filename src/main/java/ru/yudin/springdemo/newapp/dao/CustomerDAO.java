package ru.yudin.springdemo.newapp.dao;

import ru.yudin.springdemo.newapp.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

}
