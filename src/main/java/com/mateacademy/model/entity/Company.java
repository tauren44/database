package com.mateacademy.model.entity;

import com.mateacademy.model.listener.ModelListener;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(ModelListener.class)
@EqualsAndHashCode(callSuper = true)
public class Company extends Model{

    @Column(name = "site")
    private String site;

    @ManyToMany(mappedBy = "companies")
    private Set<Project> projects = new HashSet<>();
}
