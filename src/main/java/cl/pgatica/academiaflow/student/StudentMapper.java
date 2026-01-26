package cl.pgatica.academiaflow.student;

import cl.pgatica.academiaflow.student.model.Student;
import cl.pgatica.academiaflow.student.dto.StudentCreateRequest;
import cl.pgatica.academiaflow.student.dto.StudentResponse;

public class StudentMapper {

    private StudentMapper() {
        // Constructor privado para evitar instanciación
    }

    public static Student toEntity(StudentCreateRequest request) {
        return new Student(
            request.getRut(),
            request.getNames(),
            request.getLastNames(),
            request.getEmail()
        );
    }

    public static StudentResponse toResponse(Student student) {
        return new StudentResponse(
            student.getId(),
            student.getRut(),
            student.getNames(),
            student.getLastNames(),
            student.getEmail()
        );
    }
}