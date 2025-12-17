package cl.pgatica.academiaflow.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.pgatica.academiaflow.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("""
    SELECT t FROM Teacher t
    WHERE lower(t.names) LIKE lower(concat('%', :search, '%'))
        OR lower(t.lastNames) LIKE lower(concat('%', :search, '%'))
        OR lower(t.email) LIKE lower(concat('%', :search, '%'))
        OR t.rut LIKE concat('%', :search, '%')
    """)
    List<Teacher> search(@Param("search") String search);
}