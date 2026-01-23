package cl.pgatica.academiaflow.course;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.pgatica.academiaflow.course.dto.CourseCreateRequest;
import cl.pgatica.academiaflow.course.dto.CourseUpdateRequest;
import cl.pgatica.academiaflow.course.dto.CourseResponse;
import cl.pgatica.academiaflow.course.model.Course;

import cl.pgatica.academiaflow.exception.ConflictException;
import cl.pgatica.academiaflow.exception.ResourceNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseResponse create(CourseCreateRequest request) {

        repository.findByCode(request.getCodigo())
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

   @Override
    public CourseResponse update(Long id, CourseUpdateRequest request) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura no encontrada"));

        course.setName(request.getNombre());
        course.setCredits(request.getCreditos());

        Course updated = repository.save(course);

        return CourseMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        
        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura no encontrada"));

        repository.delete(course);
    }
}