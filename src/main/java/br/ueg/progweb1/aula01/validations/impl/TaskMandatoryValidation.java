package br.ueg.progweb1.aula01.validations.impl;

import br.ueg.progweb1.aula01.model.Category;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.validations.IValidations;
import br.ueg.progweb1.aula01.validations.ValidationAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class TaskMandatoryValidation implements IValidations<Category> {
    @Override
    public void validate(Category data, ValidationAction action) {

    }
}
