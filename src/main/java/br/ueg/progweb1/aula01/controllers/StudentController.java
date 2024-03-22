package br.ueg.progweb1.aula01.controllers;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Student;
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

    @PostMapping
    @Operation(description = "End point para inclusão de aluno")
    public ResponseEntity<Object> create(@RequestBody Student student){
        Student studentSaved =  null;
        try{
            studentSaved = service.create(student);
        }catch (MandatoryException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Erro:" + e.getMessage());
        }catch (BusinessLogicException e){
                return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                        .body("Erro:"+e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: desconhecido aconteceu:"+e.getMessage());
        }
        return ResponseEntity.ok(studentSaved);
    }

    @PutMapping
    @Operation(description = "End point para inclusão de aluno")
    public ResponseEntity<Object> update(@RequestBody Student student){
        Student studentSaved =  null;
        try{
            studentSaved = service.update(student);
        }catch (MandatoryException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Erro:" + e.getMessage());
        }catch (BusinessLogicException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body("Erro:"+e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: desconhecido aconteceu:"+e.getMessage());
        }
        return ResponseEntity.ok(studentSaved);
    }

    @GetMapping
    @Operation(description = "lista todos os estudantes")
    public ResponseEntity<List<Student>> listAll(){

        List<Student> studentList = new ArrayList<>();
        try {
            studentList = service.listAll();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
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
}
