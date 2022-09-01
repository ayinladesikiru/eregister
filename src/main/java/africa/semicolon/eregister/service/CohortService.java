package africa.semicolon.eregister.service;

import africa.semicolon.eregister.dtos.CohortRequestDto;
import africa.semicolon.eregister.dtos.CohortResponseDto;
import africa.semicolon.eregister.model.Cohort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CohortService {
    CohortResponseDto save(CohortRequestDto cohortRequest);

    List<Cohort> getAllAvailableCohort();

    void deleteCohort(Long id);

    CohortResponseDto updateCohort(Long id, String updateName);


}
