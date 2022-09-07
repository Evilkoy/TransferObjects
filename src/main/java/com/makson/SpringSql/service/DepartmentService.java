package com.makson.SpringSql.service;

import com.makson.SpringSql.dao.DepartmentRepository;
import com.makson.SpringSql.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public void patchDepartment(Long id, Department department) {
        department.setId(id);
        departmentRepository.save(department);
    }
}
