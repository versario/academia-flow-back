package cl.pgatica.academiaflow.teacher;

import java.util.List;

import cl.pgatica.academiaflow.teacher.dto.TeacherCreateRequest;
import cl.pgatica.academiaflow.teacher.dto.TeacherUpdateRequest;
import cl.pgatica.academiaflow.teacher.dto.TeacherResponse;

public interface TeacherService {
    TeacherResponse create(TeacherCreateRequest request);
    List<TeacherResponse> search(String search);
    TeacherResponse update(Long id, TeacherUpdateRequest request);
    void delete(Long id);
}
