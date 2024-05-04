package br.ueg.progweb1.aula01.model.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataDTO {

    private String name;

    private String cpf;

    private LocalDate birthday;

    private String gender;
}
