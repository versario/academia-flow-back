package cl.pgatica.academiaflow.course.dto;

public class CourseResponse {

    private final Long id;
    private final String codigo;
    private final String nombre;
    private final Integer creditos;

    public CourseResponse(Long id, String codigo, String nombre, Integer creditos) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }
}
