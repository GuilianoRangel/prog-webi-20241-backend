package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicError;
import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.service.StudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class StudentServiceImpl extends GenericCrudService<Student, Long, StudentRepository> implements StudentService {



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

    protected void updateDataDBFromUpdate(Student dataToUpdate, Student dataDB) {
        dataDB.setName(dataToUpdate.getName());
        dataDB.setCourse(dataToUpdate.getCourse());
    }



    protected void validateBusinessLogicForInsert(Student dado) {
        if(Strings.isEmpty(dado.getRegisterNumber()) ){
            throw new BusinessLogicException(BusinessLogicError.MANDATORY_FIELD_NOT_FOUND);
        }
        Optional<Student> byRegisterNumber = repository.findByRegisterNumber(dado.getRegisterNumber());
        if(byRegisterNumber.isPresent()){
            throw new BusinessLogicException(BusinessLogicError.REGISTER_NUMBER_DUPLICATED);
        }

    }

    protected void validateBusinessLogicForUpdate(Student dado) {
        if(dado.getId() <= 0L ){
            throw new BusinessLogicException("Id Inválido");
        }
    }

    protected void validateBusinessLogic(Student dado) {

    }

    protected void validateMandatoryFields(Student dado) {
        if(
                Strings.isEmpty(dado.getName())
        ){
            throw new MandatoryException("Campos obrigatórios não preenchidos");
        }

    }
}
