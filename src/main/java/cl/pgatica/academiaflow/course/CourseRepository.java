package cl.pgatica.academiaflow.course;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.pgatica.academiaflow.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCode(String code);

    @Query("""
        SELECT c FROM Course c
        WHERE lower(c.code) LIKE lower(concat('%', :search, '%'))
           OR lower(c.name) LIKE lower(concat('%', :search, '%'))
    """)
    List<Course> search(@Param("search") String search);
}