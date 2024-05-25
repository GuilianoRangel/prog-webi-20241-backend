package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.GenericModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface SimpleGenericMapper<
        DTO,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > extends GenericMapper<
        DTO,
        DTO,
        DTO,
        DTO,
        MODEL,
        TYPE_PK
        > {

}
