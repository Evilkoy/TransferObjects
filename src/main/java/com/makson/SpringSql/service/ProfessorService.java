package com.makson.SpringSql.service;

import com.makson.SpringSql.dao.ProfessorRepository;
import com.makson.SpringSql.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }
}
