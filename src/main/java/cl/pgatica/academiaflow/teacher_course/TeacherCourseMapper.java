package cl.pgatica.academiaflow.teacher_course;

import cl.pgatica.academiaflow.teacher_course.dto.TeacherCourseCreateRequest;
import cl.pgatica.academiaflow.teacher_course.dto.TeacherCourseResponse;
import cl.pgatica.academiaflow.teacher_course.model.TeacherCourse;

public final class TeacherCourseMapper {

    private TeacherCourseMapper() {}

    public static TeacherCourse toEntity(TeacherCourseCreateRequest request) {
        return new TeacherCourse(
            request.getId_profesor(),
            request.getId_asignatura()
        );
    }

    public static TeacherCourseResponse toResponse(TeacherCourse entity) {
        return new TeacherCourseResponse(
            entity.getId(),
            entity.getTeacherId(),
            entity.getCourseId()
        );
    }
}
