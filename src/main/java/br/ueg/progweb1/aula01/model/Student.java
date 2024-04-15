package br.ueg.progweb1.aula01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ALUNO")
public  class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "chave", nullable = false)
    private Long id;

    @Column(name = "matricula",  nullable = false, length = 10)
    private String registerNumber;

    @NotNull
    @Column(name = "nome_aluno",  nullable = false, length = 150)
    private String name;

    @Column(name = "curso")
    private String course;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate createdDate;
}
