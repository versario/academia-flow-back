package cl.pgatica.academiaflow.teacher;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;

import cl.pgatica.academiaflow.teacher.TeacherService;
import cl.pgatica.academiaflow.teacher.dto.TeacherResponse;
import cl.pgatica.academiaflow.teacher.dto.TeacherCreateRequest;
import cl.pgatica.academiaflow.teacher.dto.TeacherUpdateRequest;

@RestController
@RequestMapping("/api/profesores")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse create(@Valid @RequestBody TeacherCreateRequest request) {
        return teacherService.create(request);
    }

    @GetMapping
    public List<TeacherResponse> search(@RequestParam(required = false) String search) {
        return teacherService.search(search);
    }

    @PutMapping("/{id}")
    public TeacherResponse update(@PathVariable Long id, @Valid @RequestBody TeacherUpdateRequest request) {
        return teacherService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
