package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.GenericModel;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.model.dtos.CreateStudentDTO;
import br.ueg.progweb1.aula01.model.dtos.UpdateStudentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

public interface GenericSimpleMapper<
        DTO,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > {
    MODEL toModel(DTO dto);

    DTO toDTO(MODEL model);

    List<DTO> toDTO(List<MODEL> modelList);
}
