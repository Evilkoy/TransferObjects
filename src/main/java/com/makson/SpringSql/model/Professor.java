package com.makson.SpringSql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String name;
    @ManyToOne
    @JoinColumn(name = "scientific_degree_id")
    private ScientificDegree scientificDegree;
    private Integer salary;
}
