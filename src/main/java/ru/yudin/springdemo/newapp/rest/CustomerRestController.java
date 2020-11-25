package ru.yudin.springdemo.newapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yudin.springdemo.newapp.entity.Customer;
import ru.yudin.springdemo.newapp.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomert(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null)
            throw new CustomerNotFoundException("customer not found id = " + customer);

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;

    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.saveCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer tempCustomer = customerService.getCustomer(customerId);

        if (tempCustomer == null)
            throw new CustomerNotFoundException("Customer not found id = " + customerId);

        customerService.deleteCustomer(customerId);

        return "Customer deleted id = " + customerId;

    }
}
