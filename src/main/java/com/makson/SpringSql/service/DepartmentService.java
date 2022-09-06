package com.makson.SpringSql.service;

import com.makson.SpringSql.dao.DepartmentRepository;
import com.makson.SpringSql.dto.DepartmentDto;
import com.makson.SpringSql.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    Mapper mapper;

    public HttpStatus createDepartment(DepartmentDto departmentDto) {
        departmentRepository.save(mapper.dtoToDepartment(departmentDto));
        return HttpStatus.CREATED;
    }

    public List<DepartmentDto> getDepartments() {
        return departmentRepository.findAll().stream()
                .map(entity -> mapper.departmentToDto(entity)).collect(Collectors.toList());
    }
}
