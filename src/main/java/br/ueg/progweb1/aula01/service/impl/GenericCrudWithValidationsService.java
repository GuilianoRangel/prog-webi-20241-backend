package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.model.GenericModel;
import br.ueg.progweb1.aula01.validations.IValidations;
import br.ueg.progweb1.aula01.validations.ValidationAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericCrudWithValidationsService<
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK,
        REPOSITORY extends JpaRepository<MODEL, TYPE_PK>
        > extends GenericCrudService<MODEL, TYPE_PK, REPOSITORY> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private List<IValidations<MODEL>> validations;

    protected void validateBusinessLogicForInsert(MODEL data) {
        validations.forEach(v -> v.validate(data, ValidationAction.CREATE));
    }

    protected  void validateBusinessLogicForUpdate(MODEL data) {
        validations.forEach(v -> v.validate(data, ValidationAction.UPDATE));
    }

    protected void validateBusinessLogic(MODEL data) {
        validations.forEach(v -> v.validate(data, ValidationAction.GENERAL));
    }

    protected  void validateMandatoryFields(MODEL data) {
        validations.forEach(v -> v.validate(data, ValidationAction.GENERAL_MANDATORY));
    }
}
