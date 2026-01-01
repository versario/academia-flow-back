package cl.pgatica.academiaflow.student;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.pgatica.academiaflow.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByRut(String rut);

    @Query("""
    SELECT t FROM Student t
    WHERE lower(t.names) LIKE lower(concat('%', :search, '%'))
        OR lower(t.lastNames) LIKE lower(concat('%', :search, '%'))
        OR lower(t.email) LIKE lower(concat('%', :search, '%'))
        OR t.rut LIKE concat('%', :search, '%')
    """)
    List<Student> search(@Param("search") String search);
}