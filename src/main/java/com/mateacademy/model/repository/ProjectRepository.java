package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Project;

public interface ProjectRepository extends ModelRepository<Project> {
    public Project create(Project project);

    public Project read(Long id);

    public Project update(Project project);

    public void delete(Project project);
}
