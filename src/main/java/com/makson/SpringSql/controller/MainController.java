package com.makson.SpringSql.controller;

import com.makson.SpringSql.dto.DepartmentDto;
import com.makson.SpringSql.dto.ProfessorDto;
import com.makson.SpringSql.model.Department;
import com.makson.SpringSql.service.DepartmentService;
import com.makson.SpringSql.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/data")
public class MainController {
    @Autowired
    ProfessorService professorService;
    @Autowired
    DepartmentService departmentService;

    @PostMapping(value = "/professors/add")
    public ResponseEntity<HttpStatus> createProfessor(@RequestBody ProfessorDto professorDto) {
        return new ResponseEntity<>(professorService.createProfessor(professorDto));
    }

    @PostMapping(value = "/departments/add")
    public ResponseEntity<HttpStatus> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto));
    }

    @GetMapping(value = "/professors/get")
    public ResponseEntity<List<ProfessorDto>> getProfessor() {
        return new ResponseEntity<>(professorService.getProfessors(), HttpStatus.OK);
    }

    @GetMapping(value = "/departments/get")
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }
}
