package com.makson.SpringSql.controller;

import com.makson.SpringSql.dto.DepartmentDto;
import com.makson.SpringSql.service.DepartmentService;
import com.makson.SpringSql.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/data/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private Mapper mapper;

    @PostMapping(value = "/add")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(mapper.departmentToDto(departmentService.createDepartment(mapper.dtoToDepartment(departmentDto))), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        return new ResponseEntity<>(departmentService.getDepartments().stream().map(entity -> mapper.departmentToDto(entity)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/patch/{id}")
    public ResponseEntity<HttpStatus> patchDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDto) {
        departmentService.patchDepartment(id, mapper.dtoToDepartment(departmentDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
