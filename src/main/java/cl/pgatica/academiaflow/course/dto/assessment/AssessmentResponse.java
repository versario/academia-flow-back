package cl.pgatica.academiaflow.course.dto.assessment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssessmentResponse {

    private final Long id;

    @JsonProperty("tipo")
    private final String type;

    @JsonProperty("numero")
    private final Integer number;

    @JsonProperty("porcentaje")
    private final Integer percentage;

    public AssessmentResponse(Long id, String type, Integer number, Integer percentage) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
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
