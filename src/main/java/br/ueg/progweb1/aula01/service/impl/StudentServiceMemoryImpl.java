/*
package br.ueg.progweb1.aula01.service.impl;

import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.repository.StudentRepository;
import br.ueg.progweb1.aula01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class StudentServiceMemoryImpl implements StudentService {

    //@Autowired
    //private StudentRepository repository;
    public List<Student> listAll(){
        List<Student> list = getStudentList();

        return list;
    }

    private static List<Student> getStudentList() {
        List<Student> list = new ArrayList<>();
        list.add(Student.builder()
                .id(10L)
                .name("teste")
                .course("curso")
                .registerNumber("100")
                .build()
        );
        return list;
    }
}
*/
