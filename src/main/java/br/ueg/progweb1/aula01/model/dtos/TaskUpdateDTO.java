package br.ueg.progweb1.aula01.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskUpdateDTO {

    private String description;

    private Boolean completed;

    private Long category_id;
}
