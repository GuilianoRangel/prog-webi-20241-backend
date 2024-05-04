package br.ueg.progweb1.aula01.controllers;

import br.ueg.progweb1.aula01.mapper.GenericMapper;
import br.ueg.progweb1.aula01.model.GenericModel;
import br.ueg.progweb1.aula01.service.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericCRUDController<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK,
        SERVICE extends CrudService<
                MODEL,
                TYPE_PK>,
        MAPPER extends GenericMapper<DTO,DTOCreate, DTOUpdate, DTOList , MODEL, TYPE_PK>
        > {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected SERVICE service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected MAPPER mapper;

    @PostMapping
    @Operation(description = "End point para inclusão de dado")
    public ResponseEntity<DTO> create(@RequestBody DTOCreate dto) {
        MODEL inputModel = mapper.fromModelCreatedToModel(dto);
        DTO resultDTO = mapper.toDTO(service.create(inputModel));
        return ResponseEntity.ok(resultDTO);
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "End point para atualização de dados")
    public ResponseEntity<DTO> update(
            @RequestBody DTOUpdate dto,
            @PathVariable("id") TYPE_PK id) {
        MODEL inputModel = mapper.fromModelUpdatedToModel(dto);
        inputModel.setId(id);
        MODEL modelSaved = service.update(inputModel);
        return ResponseEntity.ok(mapper.toDTO(modelSaved));
    }

    @GetMapping
    @Operation(description = "lista todos os estudantes")
    public ResponseEntity<List<DTOList>> listAll() {
        List<DTOList> modelList = mapper.fromModelToDTOList(service.listAll());
        return ResponseEntity.of(
                Optional.ofNullable(modelList)
        );
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "End point para obter dados por id")
    public ResponseEntity<DTO> getById(
            @PathVariable("id") TYPE_PK id
    ) {
        DTO dtoResult = mapper.toDTO(service.getById(id));
        return ResponseEntity.ok(dtoResult);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "End point para remover dados por id")
    public ResponseEntity<DTO> remove(
            @PathVariable("id") TYPE_PK id
    ) {
        DTO dtoResult = mapper.toDTO(service.deleteById(id));
        return ResponseEntity.ok(dtoResult);
    }

}
