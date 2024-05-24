package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Person;
import br.ueg.progweb1.aula01.repository.PersonRepository;
import br.ueg.progweb1.aula01.service.PersonService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends GenericCrudService<Person, Long, PersonRepository> implements PersonService {



    @Override
    protected void prepareToCreate(Person dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Person dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Person dado) {

    }

    @Override
    protected void validateBusinessLogic(Person dado) {

    }

    @Override
    protected void validateMandatoryFields(Person dado) {
        if(
                Strings.isEmpty(dado.getName())
        ){
            throw new MandatoryException("Campos obrigatórios não preenchidos");
        }
    }
}
