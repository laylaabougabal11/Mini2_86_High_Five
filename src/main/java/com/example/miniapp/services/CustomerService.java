package com.example.miniapp.services;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 8.2.2.1 Add Customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // 8.2.2.2 Get All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 8.2.2.3 Get Customer By ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    // 8.2.2.4 Update Customer
    public Customer updateCustomer(Long id, Customer updated) {
        Customer existing = getCustomerById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setPhoneNumber(updated.getPhoneNumber());
        return customerRepository.save(existing);
    }

    // 8.2.2.5 Delete Customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // 8.2.2.6 Find Customers By Email Domain
    public List<Customer> findCustomersByEmailDomain(String domain) {
        return customerRepository.findByEmailEndingWith(domain);
    }

    // 8.2.2.7 Find Customers By Phone Prefix
    public List<Customer> findCustomersByPhonePrefix(String prefix) {
        return customerRepository.findByPhoneNumberStartingWith(prefix);
    }
}
