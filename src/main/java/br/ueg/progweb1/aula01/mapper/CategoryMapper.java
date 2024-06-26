package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Category;
import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.model.dtos.CategoryDTO;
import br.ueg.progweb1.aula01.model.dtos.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, //checa se o valor é nulo antes de setar
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE //se o valor não for passado não faz nada.
)
public interface CategoryMapper extends SimpleGenericMapper<
        CategoryDTO,
        Category, // Model
        Long // PK_TYPE
        > {}
