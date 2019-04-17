package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Company;

public interface CompanyRepository extends ModelRepository<Company> {
    public Company create(Company company);

    public Company read(Long id);

    public Company update(Company company);

    public void delete(Company company);
}
