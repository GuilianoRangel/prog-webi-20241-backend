package br.ueg.progweb1.aula01.controllers;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.DataException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.mapper.StudentMapper;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.model.dtos.CreateStudentDTO;
import br.ueg.progweb1.aula01.model.dtos.UpdateStudentDTO;
import br.ueg.progweb1.aula01.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "${api.version}/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentMapper mapper;

    @PostMapping
    @Operation(description = "End point para inclusão de aluno")
    public ResponseEntity<Object> create(@RequestBody CreateStudentDTO dto){
        Student studentModel = mapper.toModel(dto);
        Student studentSaved = service.create(studentModel);
        return ResponseEntity.ok(studentSaved);
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "End point para inclusão de aluno")
    public ResponseEntity<Object> update(
            @RequestBody UpdateStudentDTO dto,
            @PathVariable("id") Long id){
        Student data = mapper.toModel(dto);
        data.setId(id);
        Student studentSaved = service.update(data);
        return ResponseEntity.ok(studentSaved);
    }

    @GetMapping
    @Operation(description = "lista todos os estudantes")
    @CrossOrigin()
    public ResponseEntity<List<Student>> listAll(){
        List<Student> studentList = service.listAll();
        return ResponseEntity.of(
                Optional.ofNullable(studentList)
        );
    }

    @GetMapping(path = "/yesterday-registers")
    @Operation(description = "lista todos os estudantes matriculados antes de hoje")
    public ResponseEntity<List<Student>> listYesterdayRegisters() {
        return ResponseEntity.of(
                Optional.ofNullable(service.listYesterdayRegisters())
        );
    }
    @GetMapping(path = "/{id}")
    @Operation(description = "End point para obter dados de aluno")
    public ResponseEntity<Object> getById(
            @PathVariable("id") Long id
    ) {
        Student studentDB = service.getById(id);
        return ResponseEntity.ok(studentDB);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "End point para remover dados de aluno")
    public ResponseEntity<Object> remove(
            @PathVariable("id") Long id
    ) {
        Student studentDB =  Student.builder().id(0L).build();
        studentDB = service.deleteById(id);
        return ResponseEntity.ok(studentDB);
    }

}
