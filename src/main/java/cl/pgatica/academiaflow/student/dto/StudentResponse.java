package cl.pgatica.academiaflow.student.dto;

public class StudentResponse {

    private final Long id;
    private final String rut;
    private final String nombres;
    private final String apellidos;
    private final String email;

    public StudentResponse(Long id, String rut, String nombres, String apellidos, String email) {
        this.id = id;
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getRut() {
        return rut;
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