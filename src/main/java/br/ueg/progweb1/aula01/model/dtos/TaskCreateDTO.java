package br.ueg.progweb1.aula01.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskCreateDTO {

    private String description;

    private Long category_id;
}
