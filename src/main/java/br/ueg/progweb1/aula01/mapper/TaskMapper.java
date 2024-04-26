package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.model.dtos.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapper implements GenericSimpleMapper<TaskDTO, Task, Long> {
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
    public TaskDTO toDTO(Task model) {
        TaskDTO value = new TaskDTO();
        value.setId(model.getId());
        value.setCompleted(model.getCompleted());
        value.setDescription(model.getDescription());

        return value;
    }

    @Override
    public List<TaskDTO> toDTO(List<Task> tasks) {
        if(tasks == null) return List.of();
        return tasks
                .stream().map(
                        this::toDTO
                        //task -> toDTO(task)
                ).toList();
    }
}
