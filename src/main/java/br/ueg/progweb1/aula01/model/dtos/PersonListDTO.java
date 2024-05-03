package br.ueg.progweb1.aula01.model.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
//TODO voltar a utilizar extends
public class PersonListDTO {

    private Long id;

    private String name;

    private String cpf;

    private Date birthday;

    private String gender;
}
