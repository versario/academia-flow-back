package cl.pgatica.academiaflow.teacher_course;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import cl.pgatica.academiaflow.teacher_course.dto.TeacherCourseCreateRequest;
import cl.pgatica.academiaflow.teacher_course.dto.TeacherCourseResponse;

@RestController
@RequestMapping("/api/profesor-asignaturas")
public class TeacherCourseController {

    private final TeacherCourseService service;

    public TeacherCourseController(TeacherCourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<TeacherCourseResponse> list() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherCourseResponse create(
            @RequestBody @Valid TeacherCourseCreateRequest request
    ) {
        return service.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
