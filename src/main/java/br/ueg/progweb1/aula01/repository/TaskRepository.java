package br.ueg.progweb1.aula01.repository;

import br.ueg.progweb1.aula01.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository
        extends JpaRepository<Task, Long> {
}
