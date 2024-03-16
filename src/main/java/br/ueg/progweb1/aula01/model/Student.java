package br.ueg.progweb1.aula01.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
    @Column(name = "chave", nullable = false)
    private Long id;

    @Column(name = "matricula",  nullable = false, length = 10)
    private String registerNumber;

    @Column(name = "nome_aluno",  nullable = false, length = 150)
    private String name;

    @Column(name = "curso")
    private String course;
}
