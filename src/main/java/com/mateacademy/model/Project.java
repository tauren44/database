package com.mateacademy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "project")
public class Project extends Model {

    @Column(name = "date")
    private String date;

    @ManyToMany(mappedBy = "projects")
    private Set<Developer> developers = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "project_company", joinColumns = {@JoinColumn(name = "project_id")},
                                        inverseJoinColumns = {@JoinColumn(name = "company_id")})
    private Set<Company> companies = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "project_customer", joinColumns = {@JoinColumn(name = "project_id")},
                                        inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    private Set<Customer> customers = new HashSet<>();
}