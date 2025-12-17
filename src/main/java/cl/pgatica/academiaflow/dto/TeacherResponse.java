package cl.pgatica.academiaflow.dto;

public class TeacherResponse {

    private Long id;
    private String rut;
    private String nombres;
    private String apellidos;
    private String email;

    public TeacherResponse(Long id, String rut, String nombres, String apellidos, String email) {
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
