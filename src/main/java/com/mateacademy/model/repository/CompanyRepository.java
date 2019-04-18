package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Company;

public interface CompanyRepository extends ModelRepository<Company> {
    Company create(Company company);

    Company read(Long id);

    Company update(Company company);

    void delete(Company company);
}
