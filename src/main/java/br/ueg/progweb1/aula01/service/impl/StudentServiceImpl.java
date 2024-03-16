package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.service.StudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;
    public List<Student> listAll(){

        return repository.findAll();
    }

    @Override
    public Student save(Student dado) {
        if(
                Objects.isNull(dado.getId()) ||
                        Strings.isEmpty(dado.getRegisterNumber()) ||
                        Strings.isEmpty(dado.getName())
        ){
            throw new MandatoryException("Campos obrigatórios não preenchidos");
        }
        if(dado.getId() == 0L ){
            throw new RuntimeException("doido");
        }
        var student = repository.save(dado);
        return student;
    }
}
