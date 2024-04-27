package br.ueg.progweb1.aula01.model.dtos;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDTO {
    private String name;

    private String course;
}
