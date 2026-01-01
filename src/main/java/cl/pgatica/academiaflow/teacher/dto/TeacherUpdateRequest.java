package cl.pgatica.academiaflow.teacher.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TeacherUpdateRequest {

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(max = 100, message = "Los nombres no pueden exceder los 100 caracteres")
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 100, message = "Los apellidos no pueden exceder los 100 caracteres")
    private String apellidos;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe tener un formato válido")
    @Size(max = 255, message = "El email no puede exceder los 255 caracteres")
    private String email;

    public TeacherUpdateRequest() {
    }

    public TeacherUpdateRequest(String nombres, String apellidos, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }
}
