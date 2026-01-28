package cl.pgatica.academiaflow.course.model.assessment;

import jakarta.persistence.*;
import cl.pgatica.academiaflow.course.model.Course;

@Entity
@Table(name = "assessments")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer percentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    protected Assessment() {}

    public Assessment(String type, Integer number, Integer percentage) {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}