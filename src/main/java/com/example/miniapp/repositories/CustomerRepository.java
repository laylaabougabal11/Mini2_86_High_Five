package com.example.miniapp.repositories;

import com.example.miniapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find customers whose email ends with the given domain (e.g. "@gmail.com")
    List<Customer> findByEmailEndingWith(String domain);

    // Find customers whose phone numbers start with the given prefix (e.g. "+20")
    List<Customer> findByPhoneNumberStartingWith(String prefix);
}
