package cl.pgatica.academiaflow.student;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;

import cl.pgatica.academiaflow.student.dto.StudentResponse;
import cl.pgatica.academiaflow.student.dto.StudentCreateRequest;
import cl.pgatica.academiaflow.student.dto.StudentUpdateRequest;

@RestController
@RequestMapping("/api/alumnos")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@Valid @RequestBody StudentCreateRequest request) {
        return studentService.create(request);
    }

    @GetMapping
    public List<StudentResponse> search(@RequestParam(required = false) String search) {
        return studentService.search(search);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentUpdateRequest request) {
        return studentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}