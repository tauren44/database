package com.mateacademy.model.repository;

import com.mateacademy.model.entity.Skill;

public interface SkillRepository extends ModelRepository<Skill> {
    Skill create(Skill skill);

    Skill read(Long id);

    Skill update(Skill skill);

    void delete(Skill skill);
}
