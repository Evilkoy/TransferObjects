package com.makson.SpringSql.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDto {
    private Long department;
    private String name;
    private Long scientificDegree;
    private Integer salary;
}
