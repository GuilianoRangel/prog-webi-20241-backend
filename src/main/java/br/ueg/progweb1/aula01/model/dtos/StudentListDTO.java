package br.ueg.progweb1.aula01.model.dtos;

import br.ueg.progweb1.aula01.model.Student;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class StudentListDTO  {
    private Long id;

    private String registerNumber;

    private String name;

    private String course;
}
