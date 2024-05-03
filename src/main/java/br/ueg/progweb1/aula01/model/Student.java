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
public  class Student implements GenericModel<Long> {
    public final static String SEQUENCE_NAME = "student_sequence";//Mude o nome para criar outro

    @Id
    @SequenceGenerator(
            name=SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME+"_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = SEQUENCE_NAME
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
