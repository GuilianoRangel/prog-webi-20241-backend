package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.model.dtos.CreateStudentDTO;
import br.ueg.progweb1.aula01.model.dtos.UpdateStudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toModel(CreateStudentDTO dto){
        Student s = new Student();
        s.setCourse(dto.getCourse());
        s.setName(dto.getName());
        s.setRegisterNumber(dto.getRegisterNumber());
        return s;
    }
    public Student toModel(UpdateStudentDTO dto){
        Student s = new Student();
        s.setCourse(dto.getCourse());
        s.setName(dto.getName());
        return s;
    }
}
