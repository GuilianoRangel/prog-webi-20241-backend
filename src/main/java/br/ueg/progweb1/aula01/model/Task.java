package br.ueg.progweb1.aula01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_category_tipo"))
    private Category category;

/*    @Override
    public Map<String, Object> getFieldValues() {
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("id",this.getId());
        maps.put("description",this.getDescription());
        maps.put("completed",this.getCompleted());
        return maps;
    }

    @Override
    public List<String> getMandatoryFields() {
        return List.of("description");
    }*/
}
