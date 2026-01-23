package cl.pgatica.academiaflow.course;

import java.util.List;

import cl.pgatica.academiaflow.course.dto.CourseCreateRequest;
import cl.pgatica.academiaflow.course.dto.CourseUpdateRequest;
import cl.pgatica.academiaflow.course.dto.CourseResponse;

public interface CourseService {
    CourseResponse create(CourseCreateRequest request);
    List<CourseResponse> search(String search);
    CourseResponse update(Long id, CourseUpdateRequest request);
    void delete(Long id);
}