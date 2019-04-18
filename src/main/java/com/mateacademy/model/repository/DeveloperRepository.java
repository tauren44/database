package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Developer;

public interface DeveloperRepository extends ModelRepository<Developer> {
    Developer create(Developer developer);

    Developer read(Long id);

    Developer update(Developer developer);

    void delete(Developer developer);
}
