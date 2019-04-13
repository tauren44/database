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

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends Model{

    @Column(name = "country")
    private String country;

    @ManyToMany(mappedBy = "customers")
    private Set<Project> projects = new HashSet<>();
}
