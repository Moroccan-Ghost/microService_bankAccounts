package com.enset.microService_bankAccounts.repositories;

import com.enset.microService_bankAccounts.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
