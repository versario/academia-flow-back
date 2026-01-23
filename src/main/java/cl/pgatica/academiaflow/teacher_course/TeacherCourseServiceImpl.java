package cl.pgatica.academiaflow.teacher_course;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.pgatica.academiaflow.teacher_course.dto.TeacherCourseCreateRequest;
import cl.pgatica.academiaflow.teacher_course.dto.TeacherCourseResponse;
import cl.pgatica.academiaflow.teacher_course.model.TeacherCourse;
import cl.pgatica.academiaflow.exception.ConflictException;
import cl.pgatica.academiaflow.exception.ResourceNotFoundException;
import cl.pgatica.academiaflow.teacher.TeacherRepository;
import cl.pgatica.academiaflow.course.CourseRepository;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

    private final TeacherCourseRepository repository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public TeacherCourseServiceImpl(
            TeacherCourseRepository repository,
            TeacherRepository teacherRepository,
            CourseRepository courseRepository
    ) {
        this.repository = repository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public TeacherCourseResponse create(TeacherCourseCreateRequest request) {

        // Validar existencia del profesor
        if (!teacherRepository.existsById(request.getId_profesor())) {
            throw new ResourceNotFoundException("Profesor no encontrado");
        }

        // Validar existencia de la asignatura
        if (!courseRepository.existsById(request.getId_asignatura())) {
            throw new ResourceNotFoundException("Asignatura no encontrada");
        }

        // Validar relación duplicada
        repository.findByTeacherIdAndCourseId(
            request.getId_profesor(),
            request.getId_asignatura()
        ).ifPresent(tc -> {
            throw new ConflictException("El profesor ya está asignado a esta asignatura");
        });

        // Crear relación
        TeacherCourse entity = TeacherCourseMapper.toEntity(request);
        TeacherCourse saved = repository.save(entity);

        return TeacherCourseMapper.toResponse(saved);
    }

    @Override
    public List<TeacherCourseResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(TeacherCourseMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        TeacherCourse entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignación no encontrada"));

        repository.delete(entity);
    }
}
