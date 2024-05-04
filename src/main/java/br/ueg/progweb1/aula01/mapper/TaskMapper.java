package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.model.dtos.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS // é o que faz setar apenas os atributos com valor
)
public interface TaskMapper extends GenericMapper<
        TaskDTO, // DTO Geral
        TaskDTO, // DTO Create
        TaskDTO, // DTO Update
        TaskDTO, // DTO List
        Task, // Model
        Long // PK_TYPE
        > {}
