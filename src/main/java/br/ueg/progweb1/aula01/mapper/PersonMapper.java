package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Person;
import br.ueg.progweb1.aula01.model.dtos.PersonDTO;
import br.ueg.progweb1.aula01.model.dtos.PersonDataDTO;
import br.ueg.progweb1.aula01.model.dtos.PersonListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

//TODO explicar o nullValueCheckStrategy
@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface PersonMapper extends GenericMapper<
        PersonDTO, // DTO Geral
        PersonDataDTO, // DTO Create
        PersonDataDTO, // DTO Update
        PersonListDTO, // DTO List
        Person, // Model
        Long // PK_TYPE
        > {
}
