package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Category;
import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.repository.CategoryRepository;
import br.ueg.progweb1.aula01.repository.TaskRepository;
import br.ueg.progweb1.aula01.service.CategoryService;
import br.ueg.progweb1.aula01.service.TaskService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoryServiceImpl extends GenericCrudWithValidationsService<Category, Long, CategoryRepository> implements CategoryService {
    @Override
    protected void prepareToCreate(Category dado) {
        dado.setId(null);
    }

}
