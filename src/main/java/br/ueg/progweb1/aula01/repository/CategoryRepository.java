package br.ueg.progweb1.aula01.repository;

import br.ueg.progweb1.aula01.model.Category;
import br.ueg.progweb1.aula01.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}
