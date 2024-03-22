package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicError;
import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.DataException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.service.StudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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
    public Student update(Student dataToUpdate){
        var dataDB = validateIdStudentExists(dataToUpdate.getId());
        validateMandatoryFields(dataToUpdate);
        validateBusinessLogic(dataToUpdate);
        validateBusinessLogicForUpdate(dataToUpdate);
        updateDataDBFromUpdate(dataToUpdate, dataDB);
        return repository.save(dataDB);
    }

    @Override
    public List<Student> listYesterdayRegisters() {
        Optional<List<Student>> listagem = repository.findYesterdayRegister();
        if(listagem.isPresent()){
            return listagem.get();
        }
        return new ArrayList<>();
    }

    private void updateDataDBFromUpdate(Student dataToUpdate, Student dataDB) {
        dataDB.setName(dataToUpdate.getName());
        dataDB.setCourse(dataToUpdate.getCourse());
    }

    private Student validateIdStudentExists(Long id){
        boolean valid = true;
        Student dadoBD = null;

        if(Objects.nonNull(id)) {
            dadoBD = this.getById(id);
            if (dadoBD == null) {
                valid = false;
            }
        }else{
            valid = false;
        }

        if(Boolean.FALSE.equals(valid)){
            throw new DataException("Estudante não existe");
        }
        return dadoBD;
    }

    private Student getById(Long id){
        return repository.getReferenceById(id);
    }

    private void validateBusinessLogicForInsert(Student dado) {
        if(Strings.isEmpty(dado.getRegisterNumber()) ){
            throw new BusinessLogicException(BusinessLogicError.MANDATORY_FIELD_NOT_FOUND);
        }
        Optional<Student> byRegisterNumber = repository.findByRegisterNumber(dado.getRegisterNumber());
        if(byRegisterNumber.isPresent()){
            throw new BusinessLogicException(BusinessLogicError.REGISTER_NUMBER_DUPLICATED);
        }

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
                Strings.isEmpty(dado.getName())
        ){
            throw new MandatoryException("Campos obrigatórios não preenchidos");
        }

    }
}
