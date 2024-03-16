package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.service.StudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Student create(Student dado) {
        prepareToCreate(dado);
        validateMandatoryFields(dado);
        validateBusinessLogic(dado);
        validateBusinessLogicForInsert(dado);
        return repository.save(dado);
    }

    private void prepareToCreate(Student dado) {
        dado.setId(null);
        dado.setCreatedDate(LocalDate.now());
    }

    @Override
    public Student update(Student dado){
        validateMandatoryFields(dado);
        validateBusinessLogic(dado);
        validateBusinessLogicForUpdate(dado);
        return repository.save(dado);
    }

    private void validateBusinessLogicForInsert(Student dado) {

    }

    private void validateBusinessLogicForUpdate(Student dado) {
        if(dado.getId() <= 0L ){
            throw new BusinessLogicException("Id Inválido");
        }
    }

    private void validateBusinessLogic(Student dado) {

    }

    private void validateMandatoryFields(Student dado) {
        if(
                Strings.isEmpty(dado.getRegisterNumber()) ||
                Strings.isEmpty(dado.getName())
        ){
            throw new MandatoryException("Campos obrigatórios não preenchidos");
        }

    }
}
