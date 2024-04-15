package br.ueg.progweb1.aula01.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDTO {
    @Schema(description = "Número de matricula",example = "22222")
    private String registerNumber;

    @NotNull
    @Schema(description = "Nome do aluno", example = "nome do aluno")
    private String name;

    @Schema(description = "Nome do Curso", example = "Sistemas")
    private String course;

}
