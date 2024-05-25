package br.ueg.progweb1.aula01.model.dtos;

import br.ueg.progweb1.aula01.model.Task;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
public class TaskDTO {
    private Long id;

    private String description;

    private Boolean completed;

    private Long category_id;

    private String category_name;
}
