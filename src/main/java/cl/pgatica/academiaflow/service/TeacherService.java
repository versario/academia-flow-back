package cl.pgatica.academiaflow.service;

import java.util.List;

import cl.pgatica.academiaflow.dto.TeacherResponse;

public interface TeacherService {

    List<TeacherResponse> search(String search);
}
