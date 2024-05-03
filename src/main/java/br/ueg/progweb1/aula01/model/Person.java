package br.ueg.progweb1.aula01.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA")
public class Person implements GenericModel<Long> {
    public final static String SEQUENCE_NAME = "person_sequence";//Mude o nome para criar outro

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
    @Column(name = "CODIGO", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "ANIVERSARIO")
    private Date birthday;

    @Column(name ="SEXO")
    private String gender;
}
