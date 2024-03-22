package br.ueg.progweb1.aula01.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentDTO {
    private String name;

    private String course;
}
