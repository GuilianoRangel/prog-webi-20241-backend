package br.ueg.progweb1.aula01.repository;

import br.ueg.progweb1.aula01.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository
        extends JpaRepository<Person, Long> {
}
