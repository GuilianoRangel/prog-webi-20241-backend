package br.ueg.progweb1.aula01.service;

import br.ueg.progweb1.aula01.model.Category;
import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.CategoryRepository;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Component
public class AppStartupRunner implements ApplicationRunner {
    public static final String CREATE_DROP="create-drop";

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void initDados(){
        LOG.info("Inicio da execução do InitDados!");
        if(!this.ddlAuto.equalsIgnoreCase(CREATE_DROP)){
            return;
        }
        Student student = null;
        for (int i = 1; i<=30; i++){
            student = Student.builder()
                    .registerNumber("230322001")
                    .name("Fulano da Silva"+i)
                    .course("Sistemas de Informação")
                    .createdDate(LocalDate.now().minusDays(1))
                    .build();
            this.studentRepository.save(student);
        }

        Category cat1 = Category.builder().name("Prioridade Baixa").build();
        Category cat2 = Category.builder().name("Prioridade Média").build();
        Category cat3 = Category.builder().name("Prioridade Alta").build();
        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
        LOG.info("Fim da execução");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            this.initDados();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
