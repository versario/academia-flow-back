package cl.pgatica.academiaflow.course;

import java.util.stream.Collectors;

import cl.pgatica.academiaflow.course.dto.CourseCreateRequest;
import cl.pgatica.academiaflow.course.dto.CourseResponse;
import cl.pgatica.academiaflow.course.dto.CourseUpdateRequest;
import cl.pgatica.academiaflow.course.model.Course;

public class CourseMapper {

    private CourseMapper() {
        // Constructor privado para evitar instanciación
    }

    public static Course toEntity(CourseCreateRequest request) {
        return new Course(
            request.getCode(),
            request.getName(),
            request.getCredits()
        );
    }

    public static void updateEntity(Course course, CourseUpdateRequest request) {
        course.setName(request.getName());
        course.setCredits(request.getCredits());
    }

    public static CourseResponse toResponse(Course course) {
        return new CourseResponse(
            course.getId(),
            course.getCode(),
            course.getName(),
            course.getCredits(),
            course.getAssignments()
                .stream()
                .map(AssessmentMapper::toResponse)
                .collect(Collectors.toList())
        );
    }
}