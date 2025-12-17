package cl.pgatica.academiaflow.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.pgatica.academiaflow.model.Teacher;
import cl.pgatica.academiaflow.service.TeacherService;
import cl.pgatica.academiaflow.dto.TeacherResponse;

@RestController
@RequestMapping("/api/profesores")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherResponse> search(@RequestParam(required = false) String search) {
        return teacherService.search(search);
    }
}
