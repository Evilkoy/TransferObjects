package com.makson.SpringSql.dao;

import com.makson.SpringSql.model.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    public List<Professor> findAll();
}
