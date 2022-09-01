package africa.semicolon.eregister.service;

import africa.semicolon.eregister.dtos.CohortRequestDto;
import africa.semicolon.eregister.dtos.CohortResponseDto;
import africa.semicolon.eregister.model.Cohort;
import africa.semicolon.eregister.repository.CohortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CohortServiceImpl implements CohortService{
    private final CohortRepository cohortRepository;

    @Override
    public CohortResponseDto save(CohortRequestDto cohortRequest) {
        Cohort cohort = new Cohort();
        cohort.setCohortName(cohortRequest.getCohortName());

        Cohort savedCohort = cohortRepository.save(cohort);

        return CohortResponseDto
                .builder()
                .cohortName(savedCohort.getCohortName())
                .cohortNumber(savedCohort.getCohortNumber())
                .id(savedCohort.getId())
                .build();
    }

    @Override
    public List<Cohort> getAllAvailableCohort() {
        return new ArrayList<>(cohortRepository.findAll());
    }

    @Override
    public void deleteCohort(Long id) {
        cohortRepository.deleteById(id);
    }

    @Override
    public CohortResponseDto updateCohort(Long id, String updateName) {
        Optional<Cohort> optionalCohort = cohortRepository.findById(id);
        if (optionalCohort.isPresent()){
            Cohort cohort = optionalCohort.get();
            cohort.setCohortName(updateName);
           cohortRepository.save(cohort);
       }
        return null;

    }


}
