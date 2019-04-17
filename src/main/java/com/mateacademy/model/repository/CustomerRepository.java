package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Customer;

public interface CustomerRepository extends ModelRepository<Customer> {
    public Customer create(Customer customer);

    public Customer read(Long id);

    public Customer update(Customer customer);

    public void delete(Customer customer);
}
