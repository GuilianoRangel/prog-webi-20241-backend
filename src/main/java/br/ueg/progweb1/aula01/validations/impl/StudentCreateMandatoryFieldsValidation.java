package br.ueg.progweb1.aula01.validations.impl;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicError;
import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.validations.IValidations;
import br.ueg.progweb1.aula01.validations.ValidationAction;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Order(1000)
@Component
public class StudentCreateMandatoryFieldsValidation implements IValidations<Student> {

    @Override
    public void validate(Student data, ValidationAction action) {
        if(Objects.equals(ValidationAction.CREATE, action)) {
            if(Strings.isEmpty(data.getRegisterNumber()) ){
                throw new BusinessLogicException(BusinessLogicError.MANDATORY_FIELD_NOT_FOUND);
            }
        }
    }
}
