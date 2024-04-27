package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.model.dtos.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapper implements GenericMapper<
        TaskDTO,
        TaskDTO,
        TaskDTO,
        TaskDTO,
        Task,
        Long
        > {
    @Override
    public Task toModel(TaskDTO taskDTO) {
        Task value = Task.builder()
                .id(taskDTO.getId())
                .completed(taskDTO.getCompleted())
                .description(taskDTO.getDescription())
                .build();
        return value;
    }

    @Override
    public Task fromModelCreatedToModel(TaskDTO taskDTO) {
        return toModel(taskDTO);
    }

    @Override
    public Task fromModelUpdatedToModel(TaskDTO taskDTO) {
        return toModel(taskDTO);
    }


    @Override
    public TaskDTO toDTO(Task model) {
        TaskDTO value = new TaskDTO();
        value.setId(model.getId());
        value.setCompleted(model.getCompleted());
        value.setDescription(model.getDescription());

        return value;
    }

    @Override
    public TaskDTO toDTOList(Task model) {
        return toDTO(model);
    }


    @Override
    public List<TaskDTO> fromModelToDTOList(List<Task> tasks) {
        if(tasks == null) return List.of();
        return tasks
                .stream().map(
                        this::toDTO
                        //task -> toDTO(task)
                ).toList();
    }
}
