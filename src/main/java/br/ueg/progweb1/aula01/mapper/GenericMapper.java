package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.GenericModel;

import java.util.List;

public interface GenericMapper<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > {
    MODEL toModel(DTO dto);
    MODEL fromModelCreatedToModel(DTOCreate dtoCreate);
    MODEL fromModelUpdatedToModel(DTOUpdate dtoUpdate);

    DTO toDTO(MODEL model);
    DTOList toDTOList(MODEL model);

    List<DTOList> fromModelToDTOList(List<MODEL> modelList);
}
