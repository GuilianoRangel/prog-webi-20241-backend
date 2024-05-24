package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.exceptions.BusinessLogicException;
import br.ueg.progweb1.aula01.exceptions.MandatoryException;
import br.ueg.progweb1.aula01.model.Task;
import br.ueg.progweb1.aula01.repository.TaskRepository;
import br.ueg.progweb1.aula01.service.TaskService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TaskServiceImpl extends GenericCrudService<Task, Long, TaskRepository> implements TaskService {
    @Override
    protected void prepareToCreate(Task dado) {
        dado.setId(null);
    }
    //TODO Explicar o uso do método generic.
    // remover após explicação
/*    @Override
    protected void updateDataDBFromUpdate(Task dataToUpdate, Task dataDB) {
        dataDB.setDescription(dataToUpdate.getDescription());
        dataDB.setCompleted(dataToUpdate.getCompleted());
    }*/

    @Override
    protected void validateBusinessLogicForInsert(Task dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Task dado) {
        Task byId = this.getById(dado.getId());

        //TODO falar sobre o uso de Objects.equals para compara livre de nullpointer
        if ( Objects.equals(byId.getCompleted(), dado.getCompleted()) ) {
            String error = "Tarefa já está "+
                    (Boolean.TRUE.equals(byId.getCompleted()) ?
                    "completada" : "não completada");
            throw new MandatoryException(error);
        }
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
