package br.ueg.progweb1.aula01.validations.impl;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicError;
import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.validations.IValidations;
import br.ueg.progweb1.aula01.validations.ValidationAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1001)
@Component
public class StudentSizeRegisterNumberValidation implements IValidations<Student> {
    @Autowired
    protected StudentRepository repository;
    @Override
    public void validate(Student data, ValidationAction action) {
        if(Arrays.asList(
                ValidationAction.CREATE
        ).contains(action) ) {
            if(data.getRegisterNumber().length()>5){
                throw new BusinessLogicException(BusinessLogicError.REGISTER_NUMBER_INVALID);
            }
        }
    }
}
