package cl.pgatica.academiaflow.course.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cl.pgatica.academiaflow.course.dto.assessment.AssessmentCreateRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public class CourseUpdateRequest {

    @JsonProperty("nombre")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String name;

    @JsonProperty("creditos")
    @NotNull(message = "Los créditos son obligatorios")
    @Min(value = 1, message = "Los créditos deben ser mayores a 0")
    private Integer credits;

    @JsonProperty("evaluaciones")
    private List<AssessmentCreateRequest> assessments;

    public CourseUpdateRequest() {
    }

    public CourseUpdateRequest(String name, Integer credits, List<AssessmentCreateRequest> assessments) {
        this.name = name;
        this.credits = credits;
        this.assessments = assessments;
    }

    public String getName() {
        return name;
    }

    public Integer getCredits() {
        return credits;
    }

    public List<AssessmentCreateRequest> getAssessments() {
        return assessments;
    }
}