package cl.pgatica.academiaflow.teacher;

import cl.pgatica.academiaflow.teacher.dto.TeacherResponse;
import cl.pgatica.academiaflow.teacher.dto.TeacherCreateRequest;
import cl.pgatica.academiaflow.teacher.model.Teacher;

public class TeacherMapper {

    private TeacherMapper() {
        // Constructor privado para evitar instanciación
    }

    public static Teacher toEntity(TeacherCreateRequest request) {
        return new Teacher(
            request.getRut(),
            request.getNombres(),
            request.getApellidos(),
            request.getEmail()
        );
    }

    public static TeacherResponse toResponse(Teacher teacher) {
        return new TeacherResponse(
            teacher.getId(),
            teacher.getRut(),
            teacher.getNames(),
            teacher.getLastNames(),
            teacher.getEmail()
        );
    }
}
