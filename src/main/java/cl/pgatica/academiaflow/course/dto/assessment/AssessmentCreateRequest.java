package cl.pgatica.academiaflow.course.dto.assessment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;

public class AssessmentCreateRequest {

    @JsonProperty("tipo")
    @NotBlank(message = "El tipo es obligatorio")
    private String type;

    @JsonProperty("numero")
    @NotNull(message = "El número es obligatorio")
    private Integer number;

    @JsonProperty("porcentaje")
    @Min(value = 1, message = "El porcentaje debe ser al menos 1")
    @Max(value = 100, message = "El porcentaje debe ser como máximo 100")
    private Integer percentage;

    public AssessmentCreateRequest() {
    }

    public AssessmentCreateRequest(String type, Integer number, Integer percentage) {
        this.type = type;
        this.number = number;
        this.percentage = percentage;
    }

    public String getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getPercentage() {
        return percentage;
    }
}
