package cl.pgatica.academiaflow.teacher_course.dto;

import jakarta.validation.constraints.NotNull;

public class TeacherCourseCreateRequest {

    @NotNull
    private Long id_profesor;

    @NotNull
    private Long id_asignatura;

    public Long getId_profesor() {
        return id_profesor;
    }

    public Long getId_asignatura() {
        return id_asignatura;
    }
}
