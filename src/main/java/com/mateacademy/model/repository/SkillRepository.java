package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Skill;

public interface SkillRepository extends ModelRepository<Skill> {
    public Skill create(Skill skill);

    public Skill read(Long id);

    public Skill update(Skill skill);

    public void delete(Skill skill);
}
