package br.ueg.progweb1.aula01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
// TODO Explicar como utilizar de Herança no DTO
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TASK")
public  class Task implements GenericModel<Long> {

    @Id
    @SequenceGenerator(
            name="task_sequence",
            sequenceName = "task_sequence_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "task_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "descricao",  nullable = false, length = 200)
    private String description;

    @Column(name = "concluida")
    private Boolean completed;

}
