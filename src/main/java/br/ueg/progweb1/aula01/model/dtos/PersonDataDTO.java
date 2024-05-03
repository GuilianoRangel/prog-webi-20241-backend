package br.ueg.progweb1.aula01.model.dtos;

import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataDTO {

    private String name;

    private String cpf;

    private Date birthday;

    private String gender;
}
