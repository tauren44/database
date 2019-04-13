package com.mateacademy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "skills")
public class Skill extends Model {

    @Column(name = "lvl")
    private String lvl;

    @ManyToMany(mappedBy = "skills")
    private Set<Developer> developers = new HashSet<>();
}
