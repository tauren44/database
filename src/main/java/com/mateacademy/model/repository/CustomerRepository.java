package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Customer;

public interface CustomerRepository extends ModelRepository<Customer> {
    Customer create(Customer customer);

    Customer read(Long id);

    Customer update(Customer customer);

    void delete(Customer customer);
}
