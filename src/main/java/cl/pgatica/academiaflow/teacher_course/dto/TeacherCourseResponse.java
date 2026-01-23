package cl.pgatica.academiaflow.teacher_course.dto;

public class TeacherCourseResponse {

    private final Long id;
    private final Long id_profesor;
    private final Long id_asignatura;

    public TeacherCourseResponse(Long id, Long id_profesor, Long id_asignatura) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.id_asignatura = id_asignatura;
    }

    public Long getId() {
        return id;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public Long getId_asignatura() {
        return id_asignatura;
    }
}
