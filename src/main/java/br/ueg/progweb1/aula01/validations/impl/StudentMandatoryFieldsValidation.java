package br.ueg.progweb1.aula01.validations.impl;

import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.validations.IValidations;
import br.ueg.progweb1.aula01.validations.ValidationAction;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Order(0)
@Component
public class StudentMandatoryFieldsValidation implements IValidations<Student> {
    @Autowired
    protected StudentRepository repository;
    @Override
    public void validate(Student data, ValidationAction action) {
        if(Objects.equals(ValidationAction.GENERAL_MANDATORY, action)){
            if(
                    Strings.isEmpty(data.getName())
            ){
                throw new MandatoryException("Campos obrigatórios não preenchidos");
            }
        }
    }
}
