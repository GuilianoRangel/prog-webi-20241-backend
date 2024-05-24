package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class StudentServiceImpl extends GenericCrudWithValidationsService<Student, Long, StudentRepository> implements StudentService {

    protected void prepareToCreate(Student dado) {
        dado.setId(null);
        dado.setCreatedDate(LocalDate.now());
    }

    @Override
    public List<Student> listYesterdayRegisters() {
        Optional<List<Student>> listagem = repository.findYesterdayRegister();
        if(listagem.isPresent()){
            return listagem.get();
        }
        return new ArrayList<>();
    }
}
