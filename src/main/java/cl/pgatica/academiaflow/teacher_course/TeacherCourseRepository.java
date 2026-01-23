package cl.pgatica.academiaflow.teacher_course;

import cl.pgatica.academiaflow.teacher_course.model.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Long> {

    Optional<TeacherCourse> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

}