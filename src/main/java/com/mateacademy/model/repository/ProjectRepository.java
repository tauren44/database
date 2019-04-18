package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Project;

public interface ProjectRepository extends ModelRepository<Project> {
    Project create(Project project);

    Project read(Long id);

    Project update(Project project);

    void delete(Project project);
}
