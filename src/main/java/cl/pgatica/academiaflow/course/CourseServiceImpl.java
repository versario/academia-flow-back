package cl.pgatica.academiaflow.course;

import java.util.List;

import org.hibernate.sql.ast.tree.update.Assignment;
import org.springframework.stereotype.Service;

import cl.pgatica.academiaflow.course.dto.CourseCreateRequest;
import cl.pgatica.academiaflow.course.dto.CourseUpdateRequest;
import cl.pgatica.academiaflow.course.dto.CourseResponse;
import cl.pgatica.academiaflow.course.model.Course;
import cl.pgatica.academiaflow.course.model.assessment.Assessment;
import cl.pgatica.academiaflow.exception.ConflictException;
import cl.pgatica.academiaflow.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseResponse create(CourseCreateRequest request) {

        repository.findByCode(request.getCode())
            .ifPresent(c -> {
                throw new ConflictException("Ya existe un curso con ese código");
            });

        Course course = CourseMapper.toEntity(request);
        Course saved = repository.save(course);

        return CourseMapper.toResponse(saved);
    }

    @Override
    public List<CourseResponse> search(String search) {
        List<Course> courses;

        if (search == null || search.isBlank()) {
            courses = repository.findAll();
        } else {
            courses = repository.search(search.trim());
        }

        return courses.stream()
                .map(CourseMapper::toResponse)
                .toList();
    }

   @Transactional
    public CourseResponse update(Long id, CourseUpdateRequest request) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura no encontrada"));

        CourseMapper.updateEntity(course, request);

        if (request.getAssessments() != null) {
            request.getAssessments().forEach(asReq -> {
                Assessment assessment = AssessmentMapper.toEntity(asReq);
                course.addAssessment(assessment);
            });
        }

        return CourseMapper.toResponse(course);
    }

    @Override
    public void delete(Long id) {
        
        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura no encontrada"));

        repository.delete(course);
    }
}