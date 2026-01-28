package cl.pgatica.academiaflow.course.model;

import java.util.ArrayList;
import java.util.List;

import cl.pgatica.academiaflow.course.model.assessment.Assessment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "courses",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
    }
)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, updatable = false, length = 20)
    private String code;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "credits", nullable = false)
    private Integer credits;

    @OneToMany(
        mappedBy = "course",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Assessment> assessments = new ArrayList<>();

    protected Course() {
    }

    public Course(String code, String name, Integer credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public Long getId() {
        return id;
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

    public List<Assessment> getAssignments() {
        return assessments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
        assessment.setCourse(this);
    }
}
