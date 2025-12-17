package cl.pgatica.academiaflow.mapper;

import cl.pgatica.academiaflow.dto.TeacherResponse;
import cl.pgatica.academiaflow.model.Teacher;

public class TeacherMapper {

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
