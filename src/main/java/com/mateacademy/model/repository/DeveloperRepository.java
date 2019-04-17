package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Developer;

public interface DeveloperRepository extends ModelRepository<Developer> {
    public Developer create(Developer developer);

    public Developer read(Long id);

    public Developer update(Developer developer);

    public void delete(Developer developer);
}
