
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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORY")
public  class Category implements GenericModel<Long> {

    @Id
    @SequenceGenerator(
            name="category_sequence",
            sequenceName = "category_sequence_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "category_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "nome",  nullable = false, length = 40)
    private String name;

}
