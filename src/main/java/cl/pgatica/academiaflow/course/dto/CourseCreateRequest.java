package cl.pgatica.academiaflow.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;

public class CourseCreateRequest {

    @JsonProperty("codigo")
    @NotBlank(message = "El código es obligatorio")
    @Size(max = 20, message = "El código no puede exceder los 20 caracteres")
    private String code;

    @JsonProperty("nombre")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String name;

    @JsonProperty("creditos")
    @NotNull(message = "Los créditos son obligatorios")
    @Min(value = 1, message = "Los créditos deben ser mayores a 0")
    private Integer credits;

    public CourseCreateRequest() {
    }

    public CourseCreateRequest(String code, String name, Integer credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
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
}