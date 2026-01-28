package cl.pgatica.academiaflow.course.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cl.pgatica.academiaflow.course.dto.assessment.AssessmentResponse;

public class CourseResponse {

    private final Long id;

    @JsonProperty("codigo")
    private final String code;

    @JsonProperty("nombre")
    private final String name;

    @JsonProperty("creditos")
    private final Integer credits;

    @JsonProperty("evaluaciones")
    private final List<AssessmentResponse> assessments;

    public CourseResponse(Long id, String code, String name, Integer credits, List<AssessmentResponse> assessments) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.assessments = assessments;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getCredits() {
        return credits;
    }

    public List<AssessmentResponse> getAssessments() {
        return assessments;
    }
}
