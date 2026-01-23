package cl.pgatica.academiaflow.course;

import cl.pgatica.academiaflow.course.dto.CourseCreateRequest;
import cl.pgatica.academiaflow.course.dto.CourseResponse;
import cl.pgatica.academiaflow.course.model.Course;

public class CourseMapper {

    private CourseMapper() {
        // Constructor privado para evitar instanciación
    }

    public static Course toEntity(CourseCreateRequest request) {
        return new Course(
            request.getCodigo(),
            request.getNombre(),
            request.getCreditos()
        );
    }

    public static CourseResponse toResponse(Course course) {
        return new CourseResponse(
            course.getId(),
            course.getCode(),
            course.getName(),
            course.getCredits()
        );
    }
}