package africa.semicolon.eregister.repository;

import africa.semicolon.eregister.model.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository  extends JpaRepository<Cohort, Long> {
    Cohort findByCohortNumber(String number);

    Cohort findByCohortName(String cohortName);

//    Cohort findCohortById(Long id);
}
