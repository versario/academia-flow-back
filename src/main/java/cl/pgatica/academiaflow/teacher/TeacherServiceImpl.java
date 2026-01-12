package cl.pgatica.academiaflow.teacher;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.pgatica.academiaflow.teacher.model.Teacher;
import cl.pgatica.academiaflow.teacher.TeacherRepository;
import cl.pgatica.academiaflow.teacher.TeacherService;
import cl.pgatica.academiaflow.teacher.dto.TeacherResponse;
import cl.pgatica.academiaflow.teacher.dto.TeacherCreateRequest;
import cl.pgatica.academiaflow.teacher.dto.TeacherUpdateRequest;
import cl.pgatica.academiaflow.teacher.TeacherMapper;

import cl.pgatica.academiaflow.exception.ConflictException;
import cl.pgatica.academiaflow.exception.ResourceNotFoundException;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeacherResponse create(TeacherCreateRequest request) {

        repository.findByRut(request.getRut())
            .ifPresent(t -> {
                throw new ConflictException("Ya existe un profesor con ese RUT");
            });

        Teacher teacher = TeacherMapper.toEntity(request);
        Teacher saved = repository.save(teacher);

        return TeacherMapper.toResponse(saved);
    }

    @Override
    public List<TeacherResponse> search(String search) {
        List<Teacher> teachers;

        if (search == null || search.isBlank()) {
            teachers = repository.findAll();
        } else {
            teachers = repository.search(search.trim());
        }

        return teachers.stream()
                .map(TeacherMapper::toResponse)
                .toList();
    }

    @Override
    public TeacherResponse update(Long id, TeacherUpdateRequest request) {

        Teacher teacher = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado"));

        teacher.setNames(request.getNombres());
        teacher.setLastNames(request.getApellidos());
        teacher.setEmail(request.getEmail());

        Teacher updatedTeacher = repository.save(teacher);
        
        return TeacherMapper.toResponse(updatedTeacher);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado"));

        repository.delete(teacher);
    }
}
