package br.ueg.progweb1.aula01.controllers;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.DataException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.mapper.GenericSimpleMapper;
import br.ueg.progweb1.aula01.model.GenericModel;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.service.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericSimpleCRUDController<
        DTO,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK,
        SERVICE extends CrudService<
                MODEL,
                TYPE_PK>,
        MAPPER extends GenericSimpleMapper<DTO, MODEL, TYPE_PK>
        > {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected SERVICE service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected MAPPER mapper;

    @PostMapping
    @Operation(description = "End point para inclusão de dado")
    public ResponseEntity<Object> create(@RequestBody DTO dto) {
        MODEL inputModel = mapper.toModel(dto);
        MODEL resultModel = service.create(inputModel);
        return ResponseEntity.ok(resultModel);
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "End point para atualização de dados")
    public ResponseEntity<Object> update(
            @RequestBody DTO dto,
            @PathVariable("id") TYPE_PK id) {
        MODEL inputModel = mapper.toModel(dto);
        inputModel.setId(id);
        MODEL modelSaved = service.update(inputModel);
        return ResponseEntity.ok(modelSaved);
    }

    @GetMapping
    @Operation(description = "lista todos os estudantes")
    @CrossOrigin()
    public ResponseEntity<List<DTO>> listAll() {
        List<DTO> modelList = mapper.toDTO(service.listAll());
        return ResponseEntity.of(
                Optional.ofNullable(modelList)
        );
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "End point para obter dados por id")
    public ResponseEntity<Object> getById(
            @PathVariable("id") TYPE_PK id
    ) {
        DTO dtoResult = mapper.toDTO(service.getById(id));
        return ResponseEntity.ok(dtoResult);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "End point para remover dados por id")
    public ResponseEntity<Object> remove(
            @PathVariable("id") TYPE_PK id
    ) {
        DTO dtoResult = mapper.toDTO(service.deleteById(id));
        return ResponseEntity.ok(dtoResult);
    }

}
