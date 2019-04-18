package com.mateacademy.model.entity;

import com.mateacademy.model.listener.ModelListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "developers")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(ModelListener.class)
@EqualsAndHashCode(callSuper = true)
public class Developer extends Model {

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "salary")
    private Integer salary = 0;

    @ManyToMany
    @JoinTable(name = "developer_skill", joinColumns = {@JoinColumn(name = "dev_id")},
                                        inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "developer_project", joinColumns = {@JoinColumn(name = "dev_id")},
                                        inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<>();
}
