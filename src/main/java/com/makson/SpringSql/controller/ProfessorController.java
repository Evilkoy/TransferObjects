package com.makson.SpringSql.controller;

import com.makson.SpringSql.dto.ProfessorDto;
import com.makson.SpringSql.service.ProfessorService;
import com.makson.SpringSql.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "data/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private Mapper mapper;

    @PostMapping(value = "/add")
    public ResponseEntity<ProfessorDto> createProfessor(@RequestBody ProfessorDto professorDto) {
        return new ResponseEntity<>(mapper.professorToDto(professorService.createProfessor(mapper.dtoToProfessor(professorDto))), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<ProfessorDto>> getProfessors() {
        return new ResponseEntity<>(professorService.getProfessors().stream().map(entity -> mapper.professorToDto(entity)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/patch/{id}")
    public ResponseEntity<HttpStatus> patchProfessor(@PathVariable Long id, @RequestBody ProfessorDto professorDto) {
        professorService.patchProfessor(id, mapper.dtoToProfessor(professorDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
