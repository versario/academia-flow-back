package cl.pgatica.academiaflow.teacher_course.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "teacher_course",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"teacher_id", "course_id"})
    }
)
public class TeacherCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "teacher_id", updatable = false, nullable = false)
    private Long teacherId;

    @Column(name = "course_id", updatable = false, nullable = false)
    private Long courseId;

    protected TeacherCourse() {
    }

    public TeacherCourse(Long teacherId, Long courseId) {
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public Long getCourseId() {
        return courseId;
    }
}
