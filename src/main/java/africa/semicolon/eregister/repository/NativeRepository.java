package africa.semicolon.eregister.repository;

import africa.semicolon.eregister.model.Native;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NativeRepository extends JpaRepository<Native, Long> {
    List<Native> findByCohort_CohortName(String cohortName);
}
