package cl.pgatica.academiaflow.student;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.pgatica.academiaflow.student.model.Student;
import cl.pgatica.academiaflow.student.StudentRepository;
import cl.pgatica.academiaflow.student.StudentService;
import cl.pgatica.academiaflow.student.dto.StudentResponse;
import cl.pgatica.academiaflow.student.dto.StudentCreateRequest;
import cl.pgatica.academiaflow.student.dto.StudentUpdateRequest;
import cl.pgatica.academiaflow.student.StudentMapper;

import cl.pgatica.academiaflow.exception.ConflictException;
import cl.pgatica.academiaflow.exception.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentResponse create(StudentCreateRequest request) {

        repository.findByRut(request.getRut())
            .ifPresent(s -> {
                throw new ConflictException("Ya existe un alumno con ese RUT");
            });

        Student student = StudentMapper.toEntity(request);
        Student saved = repository.save(student);

        return StudentMapper.toResponse(saved);
    }

    @Override
    public List<StudentResponse> search(String search) {
        List<Student> students;

        if (search == null || search.isBlank()) {
            students = repository.findAll();
        } else {
            students = repository.search(search.trim());
        }

        return students.stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

    @Override
    public StudentResponse update(Long id, StudentUpdateRequest request) {
        
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado"));

        student.setNames(request.getNombres());
        student.setLastNames(request.getApellidos());
        student.setEmail(request.getEmail());
        
        Student updatedStudent = repository.save(student);
        
        return StudentMapper.toResponse(updatedStudent);
    }
    
    @Override
    public void delete(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado"));
                
        repository.delete(student);
    }
}