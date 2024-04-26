package br.ueg.progweb1.aula01.controllers;

import br.ueg.progweb1.aula01.exceptions.DataException;
import br.ueg.progweb1.aula01.mapper.TaskMapper;
import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.model.dtos.TaskDTO;
import br.ueg.progweb1.aula01.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.version}/task")
public class TaskController extends
GenericSimpleCRUDController<TaskDTO, Task,Long, TaskService, TaskMapper>
{
    @PostMapping(path = "/complete/{id}")
    @Operation(description = "End point para completar a tarefa")
    public ResponseEntity<Object> complated(
            @PathVariable("id") Long id
    ) {
        TaskDTO dtoResult;
        try{

            dtoResult = mapper.toDTO(service.completedTask(id));

        }catch (DataException de){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro de dados ocorreu. Detalhe:"+de.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: desconhecido aconteceu:"+e.getMessage());
        }
        return ResponseEntity.ok(dtoResult);
    }
}
