package com.makson.SpringSql.controller;

import com.makson.SpringSql.dto.DepartmentDto;
import com.makson.SpringSql.dto.ProfessorDto;
import com.makson.SpringSql.model.Department;
import com.makson.SpringSql.model.Professor;
import com.makson.SpringSql.service.DepartmentService;
import com.makson.SpringSql.service.ProfessorService;
import com.makson.SpringSql.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/data")
public class MainController {
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private Mapper mapper;

    @PostMapping(value = "/professors/add")
    public ResponseEntity<Professor> createProfessor(@RequestBody ProfessorDto professorDto) {
        return new ResponseEntity<>(professorService.createProfessor(mapper.dtoToProfessor(professorDto))
                , HttpStatus.CREATED);
    }

    @PostMapping(value = "/departments/add")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(mapper.dtoToDepartment(departmentDto))
                , HttpStatus.CREATED);
    }

    @GetMapping(value = "/professors/get")
    public ResponseEntity<List<ProfessorDto>> getProfessors() {
        return new ResponseEntity<>(professorService.getProfessors().stream().map(entity -> mapper.professorToDto(entity))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/departments/get")
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        return new ResponseEntity<>(departmentService.getDepartments().stream().map(entity -> mapper.departmentToDto(entity))
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
