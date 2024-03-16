package br.ueg.progweb1.aula01.repository;

import br.ueg.progweb1.aula01.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
}
