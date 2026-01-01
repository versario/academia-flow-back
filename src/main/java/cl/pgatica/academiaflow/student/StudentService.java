package cl.pgatica.academiaflow.student;

import java.util.List;

import cl.pgatica.academiaflow.student.dto.StudentCreateRequest;
import cl.pgatica.academiaflow.student.dto.StudentUpdateRequest;
import cl.pgatica.academiaflow.student.dto.StudentResponse;

public interface StudentService {
    StudentResponse create(StudentCreateRequest request);
    List<StudentResponse> search(String search);
    StudentResponse update(Long id, StudentUpdateRequest request);
    void delete(Long id);
}