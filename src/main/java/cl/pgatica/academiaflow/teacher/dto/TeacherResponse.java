package cl.pgatica.academiaflow.teacher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeacherResponse {

    private final Long id;

    private final String rut;

    @JsonProperty("nombres")
    private final String names;

    @JsonProperty("apellidos")
    private final String lastNames;

    private final String email;

    public TeacherResponse(Long id, String rut, String names, String lastNames, String email) {
        this.id = id;
        this.rut = rut;
        this.names = names;
        this.lastNames = lastNames;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getNames() {
        return names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public String getEmail() {
        return email;
    }
}
