package cl.pgatica.academiaflow.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.pgatica.academiaflow.model.Teacher;
import cl.pgatica.academiaflow.repository.TeacherRepository;
import cl.pgatica.academiaflow.service.TeacherService;
import cl.pgatica.academiaflow.dto.TeacherResponse;
import cl.pgatica.academiaflow.mapper.TeacherMapper;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
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
}
