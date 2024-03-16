package br.ueg.progweb1.aula01.service;

import br.ueg.progweb1.aula01.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();
    Student create(Student dado);

    Student update(Student dado);
}
