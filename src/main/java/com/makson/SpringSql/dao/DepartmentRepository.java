package com.makson.SpringSql.dao;

import com.makson.SpringSql.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    public List<Department>findAll();
}
