package cl.pgatica.academiaflow.teacher_course;

import java.util.List;

import cl.pgatica.academiaflow.teacher_course.dto.TeacherCourseCreateRequest;
import cl.pgatica.academiaflow.teacher_course.dto.TeacherCourseResponse;

public interface TeacherCourseService {

    TeacherCourseResponse create(TeacherCourseCreateRequest request);

    List<TeacherCourseResponse> findAll();

    void delete(Long id);
}
