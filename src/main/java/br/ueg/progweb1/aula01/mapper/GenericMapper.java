package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.GenericModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface GenericMapper<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > extends GenericUpdateMapper<MODEL, TYPE_PK> {
    MODEL toModel(DTO dto);
    MODEL fromModelCreatedToModel(DTOCreate dtoCreate);

    MODEL fromModelUpdatedToModel(DTOUpdate dtoUpdate);



    DTO toDTO(MODEL model);

    @Named(value = "toDTOList") // para identificar o nome desse metodo pelo mapstruct
    DTOList toDTOList(MODEL model);

    @IterableMapping(qualifiedByName = "toDTOList") // para orientar qual metodo utilizar no caso de vários target=source;
    List<DTOList> fromModelToDTOList(List<MODEL> modelList);
}
