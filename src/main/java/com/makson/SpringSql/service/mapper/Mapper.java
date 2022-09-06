package com.makson.SpringSql.service.mapper;

import com.makson.SpringSql.dao.DepartmentRepository;
import com.makson.SpringSql.dao.ProfessorRepository;
import com.makson.SpringSql.dao.ScientificDegreeRepository;
import com.makson.SpringSql.dto.DepartmentDto;
import com.makson.SpringSql.dto.ProfessorDto;
import com.makson.SpringSql.model.Department;
import com.makson.SpringSql.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ScientificDegreeRepository scientificDegreeRepository;

    public ProfessorDto professorToDto(Professor entity) {
        ProfessorDto dto = new ProfessorDto();
        dto.setName(entity.getName());
        dto.setSalary(entity.getSalary());
        dto.setScientificDegree(entity.getScientificDegree().getId());
        dto.setDepartment(entity.getDepartment().getId());
        return dto;
    }

    public Professor dtoToProfessor(ProfessorDto dto) {
        Professor entity = new Professor();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
        entity.setScientificDegree(scientificDegreeRepository.findById(dto.getScientificDegree()).orElse(null));
        entity.setDepartment(departmentRepository.findById(dto.getDepartment()).orElse(null));
        return entity;
    }

    public DepartmentDto departmentToDto(Department entity) {
        DepartmentDto dto = new DepartmentDto();
        dto.setName(entity.getName());
        dto.setLead_id(entity.getLead().getId());
        return dto;
    }

    public Department dtoToDepartment(DepartmentDto dto) {
        Department entity = new Department();
        entity.setName(dto.getName());
        entity.setLead(professorRepository.findById(dto.getLead_id()).orElse(null));
        return entity;
    }
}
