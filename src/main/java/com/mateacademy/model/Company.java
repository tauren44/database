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
@Table(name = "companies")
public class Company extends Model{

    @Column(name = "site")
    private String site;

    @ManyToMany(mappedBy = "companies")
    private Set<Project> projects = new HashSet<>();
}
