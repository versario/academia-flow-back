package cl.pgatica.academiaflow.course;

import cl.pgatica.academiaflow.course.dto.assessment.AssessmentCreateRequest;
import cl.pgatica.academiaflow.course.dto.assessment.AssessmentResponse;
import cl.pgatica.academiaflow.course.model.assessment.Assessment;

public class AssessmentMapper {

    private AssessmentMapper() {}

    public static Assessment toEntity(AssessmentCreateRequest request) {
        return new Assessment(
            request.getType(),
            request.getNumber(),
            request.getPercentage()
        );
    }

    public static AssessmentResponse toResponse(Assessment assessment) {
        return new AssessmentResponse(
            assessment.getId(),
            assessment.getType(),
            assessment.getNumber(),
            assessment.getPercentage()
        );
    }
}