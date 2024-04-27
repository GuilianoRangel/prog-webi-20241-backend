package br.ueg.progweb1.aula01.mapper;

import br.ueg.progweb1.aula01.model.Student;
import br.ueg.progweb1.aula01.model.dtos.StudentCreateDTO;
import br.ueg.progweb1.aula01.model.dtos.StudentDTO;
import br.ueg.progweb1.aula01.model.dtos.StudentListDTO;
import br.ueg.progweb1.aula01.model.dtos.StudentUpdateDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapper implements GenericMapper<
        StudentDTO,
        StudentCreateDTO,
        StudentUpdateDTO,
        StudentListDTO,
        Student,
        Long
        > {
    public Student toModel(StudentCreateDTO dto){
        Student s = new Student();
        s.setCourse(dto.getCourse());
        s.setName(dto.getName());
        s.setRegisterNumber(dto.getRegisterNumber());
        return s;
    }
    public Student toModel(StudentUpdateDTO dto){
        Student s = new Student();
        s.setCourse(dto.getCourse());
        s.setName(dto.getName());
        return s;
    }

    @Override
    public Student toModel(StudentDTO studentDTO) {
        Student s = new Student();
        s.setId(studentDTO.getId());
        s.setCourse(studentDTO.getCourse());
        s.setName(studentDTO.getName());
        s.setRegisterNumber(studentDTO.getRegisterNumber());
        s.setCreatedDate(studentDTO.getCreatedDate());
        return s;
    }

    @Override
    public Student fromModelCreatedToModel(StudentCreateDTO studentCreateDTO) {
        Student s = new Student();
        s.setRegisterNumber(studentCreateDTO.getRegisterNumber());
        s.setCourse(studentCreateDTO.getCourse());
        s.setName(studentCreateDTO.getName());
        return s;
    }

    @Override
    public Student fromModelUpdatedToModel(StudentUpdateDTO studentUpdateDTO) {
        Student s = new Student();
        s.setName(studentUpdateDTO.getName());
        s.setCourse(studentUpdateDTO.getCourse());
        return s;
    }

    @Override
    public StudentDTO toDTO(Student model) {
        StudentDTO dto = new StudentDTO();
        dto.setId(model.getId());
        dto.setCourse(model.getCourse());
        dto.setName(model.getName());
        dto.setRegisterNumber(model.getRegisterNumber());
        dto.setCreatedDate(model.getCreatedDate());
        return dto;
    }

    @Override
    public StudentListDTO toDTOList(Student model) {
        StudentListDTO dto = new StudentListDTO();
        dto.setId(model.getId());
        dto.setCourse(model.getCourse());
        dto.setName(model.getName());
        dto.setRegisterNumber(model.getRegisterNumber());
        return dto;
    }

    @Override
    public List<StudentListDTO> fromModelToDTOList(List<Student> students) {
        if (students == null) return List.of();
        return students.stream().map(this::toDTOList).toList();
    }
}
