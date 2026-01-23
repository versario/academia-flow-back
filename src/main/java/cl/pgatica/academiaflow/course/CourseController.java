package cl.pgatica.academiaflow.course;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import cl.pgatica.academiaflow.course.dto.CourseCreateRequest;
import cl.pgatica.academiaflow.course.dto.CourseUpdateRequest;
import cl.pgatica.academiaflow.course.dto.CourseResponse;

@RestController
@RequestMapping("/api/asignaturas")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse create(@Valid @RequestBody CourseCreateRequest request) {
        return courseService.create(request);
    }

    @GetMapping
    public List<CourseResponse> search(@RequestParam(required = false) String search) {
        return courseService.search(search);
    }

    @PutMapping("/{id}")
    public CourseResponse update(@PathVariable Long id, @Valid @RequestBody CourseUpdateRequest request) {
        return courseService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}