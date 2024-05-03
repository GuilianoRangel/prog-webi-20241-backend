package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.model.dtos.StudentCreateDTO;
import br.ueg.progweb1.aula01.model.dtos.StudentDTO;
import br.ueg.progweb1.aula01.model.dtos.StudentListDTO;
import br.ueg.progweb1.aula01.model.dtos.StudentUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapstructMapper extends GenericMapper<
        StudentDTO,
        StudentCreateDTO,
        StudentUpdateDTO,
        StudentListDTO,
        Student,
        Long
        > {
    @Mapping(target = "course", source = "courseRegister")
    @Override
    Student fromModelCreatedToModel(StudentCreateDTO studentCreateDTO);
}
