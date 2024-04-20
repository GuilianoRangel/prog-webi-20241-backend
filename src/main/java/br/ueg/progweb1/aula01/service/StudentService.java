package br.ueg.progweb1.aula01.service;

import br.ueg.progweb1.aula01.model.Student;

import java.util.List;

public interface StudentService extends CrudService<Student, Long>{
    List<Student> listYesterdayRegisters();
}
