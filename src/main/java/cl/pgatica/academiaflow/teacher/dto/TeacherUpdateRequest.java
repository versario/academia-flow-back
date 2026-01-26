package cl.pgatica.academiaflow.teacher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TeacherUpdateRequest {

    @JsonProperty("nombres")
    @NotBlank(message = "Los nombres son obligatorios")
    @Size(max = 100, message = "Los nombres no pueden exceder los 100 caracteres")
    private String names;

    @JsonProperty("apellidos")
    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 100, message = "Los apellidos no pueden exceder los 100 caracteres")
    private String lastNames;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe tener un formato válido")
    @Size(max = 255, message = "El email no puede exceder los 255 caracteres")
    private String email;

    public TeacherUpdateRequest() {
    }

    public TeacherUpdateRequest(String names, String lastNames, String email) {
        this.names = names;
        this.lastNames = lastNames;
        this.email = email;
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
