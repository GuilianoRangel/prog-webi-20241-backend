package br.ueg.progweb1.aula01.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO{

    private Long id;

    private String name;

    private String cpf;

    private LocalDate birthday;

    private String gender;
}
