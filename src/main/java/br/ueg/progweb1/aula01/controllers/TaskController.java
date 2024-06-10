package br.ueg.progweb1.aula01.controllers;

import br.ueg.progweb1.aula01.exceptions.DataException;
import br.ueg.progweb1.aula01.mapper.TaskMapper;
import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.model.dtos.TaskCreateDTO;
import br.ueg.progweb1.aula01.model.dtos.TaskDTO;
import br.ueg.progweb1.aula01.model.dtos.TaskUpdateDTO;
import br.ueg.progweb1.aula01.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.version}/task")
@CrossOrigin()
public class TaskController extends
GenericCRUDController<
        TaskDTO, //DTO Geral
        TaskCreateDTO, //DTO Create
        TaskUpdateDTO, //DTO Update
        TaskDTO, //DTO List
        Task, // Modelo
        Long, // PK_TYPE
        TaskService, //Interface Serviço
        TaskMapper> // Mapper
{
    @PostMapping(path = "/complete/{id}")
    @Operation(description = "End point para completar a tarefa")
    public ResponseEntity<Object> complated(
            @PathVariable("id") Long id
    ) {
        TaskDTO dtoResult;
        dtoResult = mapper.toDTO(service.completedTask(id));
        return ResponseEntity.ok(dtoResult);
    }
}
