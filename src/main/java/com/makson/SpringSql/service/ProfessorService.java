package com.makson.SpringSql.service;

import com.makson.SpringSql.dao.ProfessorRepository;
import com.makson.SpringSql.dto.ProfessorDto;
import com.makson.SpringSql.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    Mapper mapper;

    public HttpStatus createProfessor(ProfessorDto professorDto) {
        professorRepository.save(mapper.dtoToProfessor(professorDto));
        return HttpStatus.CREATED;
    }

    public List<ProfessorDto> getProfessors() {
        return professorRepository.findAll()
                .stream().map(x -> mapper.professorToDto(x)).collect(Collectors.toList());
    }
}
