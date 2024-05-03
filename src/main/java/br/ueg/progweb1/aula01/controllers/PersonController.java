package br.ueg.progweb1.aula01.controllers;

import br.ueg.progweb1.aula01.mapper.PersonMapper;
import br.ueg.progweb1.aula01.mapper.TaskMapper;
import br.ueg.progweb1.aula01.model.Person;
import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.model.dtos.PersonDTO;
import br.ueg.progweb1.aula01.model.dtos.PersonDataDTO;
import br.ueg.progweb1.aula01.model.dtos.PersonListDTO;
import br.ueg.progweb1.aula01.model.dtos.TaskDTO;
import br.ueg.progweb1.aula01.service.PersonService;
import br.ueg.progweb1.aula01.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/person")
public class PersonController extends
GenericCRUDController<
        PersonDTO, // DTO Geral
        PersonDataDTO, // DTO Create
        PersonDataDTO, // DTO Update
        PersonListDTO,
        Person, // Modelo
        Long, // PK_TYPE
        PersonService, //Interface Serviço
        PersonMapper> // Mapper
{

}
