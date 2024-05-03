package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Person;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.model.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper extends GenericMapper<
        PersonDTO, // DTO Geral
        PersonDataDTO, // DTO Create
        PersonDataDTO, // DTO Update
        PersonListDTO, // DTO List
        Person, // Model
        Long // PK_TYPE
        > {
}
