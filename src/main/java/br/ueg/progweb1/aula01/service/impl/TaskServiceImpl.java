package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.repository.TaskRepository;
import br.ueg.progweb1.aula01.service.TaskService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends GenericCrudService<Task, Long, TaskRepository> implements TaskService {
    @Override
    protected void prepareToCreate(Task dado) {
        dado.setId(null);
    }

    @Override
    protected void updateDataDBFromUpdate(Task dataToUpdate, Task dataDB) {
        dataDB.setDescription(dataToUpdate.getDescription());
        dataDB.setCompleted(dataToUpdate.getCompleted());
    }

    @Override
    protected void validateBusinessLogicForInsert(Task dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Task dado) {

    }

    @Override
    protected void validateBusinessLogic(Task dado) {

    }

    @Override
    protected void validateMandatoryFields(Task dado) {
        if(
                Strings.isEmpty(dado.getDescription())
        ){
            throw new MandatoryException("Campos obrigatórios não preenchidos");
        }
    }

    @Override
    public Task completedTask(Long id){
        Task task = this.getById(id);
        if(task.getCompleted()){
            throw new BusinessLogicException("Tarefa já completada");
        }
        task.setCompleted(true);
        task = repository.save(task);
        return task;
    }
}
