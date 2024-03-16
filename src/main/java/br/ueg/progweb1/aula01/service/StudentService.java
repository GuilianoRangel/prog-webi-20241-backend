package br.ueg.progweb1.aula01.service;

import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> listAll();
    Student save(Student dado);
}
