package africa.semicolon.eregister.service;

import africa.semicolon.eregister.dtos.CohortRequestDto;
import africa.semicolon.eregister.dtos.CohortResponseDto;
import africa.semicolon.eregister.dtos.NativeRequestDto;
import africa.semicolon.eregister.dtos.NativeResponseDto;
import africa.semicolon.eregister.model.Cohort;
import africa.semicolon.eregister.repository.CohortRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CohortServiceImplTest {

    @Autowired
    private CohortService cohortService;

    @Autowired
    private CohortRepository cohortRepository;

    @BeforeEach
    void setUp() {
        cohortRepository.deleteAll();
    }

    @Test
    void save() {
        CohortRequestDto cohortRequestDto = new CohortRequestDto("Dekanorbs");

        CohortResponseDto cohortResponseDto = cohortService.save(cohortRequestDto);
        log.info("{}",  cohortResponseDto);
        assertEquals(cohortRepository.count(), 1);
    }

    @Test
    void getAllAvailableCohort(){
        CohortRequestDto cohortRequestDto1 = new CohortRequestDto("Dekanorbs");
        CohortRequestDto cohortRequestDto2 = new CohortRequestDto("Sages");
        CohortRequestDto cohortRequestDto3 = new CohortRequestDto("Dekanorbs");

        CohortResponseDto cohortResponseDto1 = cohortService.save(cohortRequestDto1);
        CohortResponseDto cohortResponseDto2 = cohortService.save(cohortRequestDto2);
        CohortResponseDto cohortResponseDto3 = cohortService.save(cohortRequestDto3);
        log.info("{}",cohortResponseDto1);
        log.info("{}",cohortResponseDto2);
        log.info("{}",cohortResponseDto3);

        assertEquals(3, cohortRepository.count());
    }

    @Test
    void deleteCohort(){
        CohortRequestDto cohortRequestDto1 = new CohortRequestDto("Dekanorbs");
        CohortRequestDto cohortRequestDto2 = new CohortRequestDto("Sages");

        CohortResponseDto cohortResponseDto2 = cohortService.save(cohortRequestDto2);
        CohortResponseDto cohortResponseDto1 = cohortService.save(cohortRequestDto1);

        Cohort cohort = cohortRepository.findByCohortNumber(cohortResponseDto2.getCohortNumber());
        cohortService.deleteCohort(cohort.getId());

        assertEquals(1, cohortRepository.count());
    }

    @Test
    void updateCohort(){
        CohortRequestDto cohortRequestDto1 = new CohortRequestDto("Dekanorbs");
        CohortResponseDto savedCohort = cohortService.save(cohortRequestDto1);

        cohortService.updateCohort(savedCohort.getId(),"champs");
        log.info("{}", savedCohort.getCohortNumber(), savedCohort.getCohortName());
        Cohort cohort = cohortRepository.findByCohortName("champs");
        assertEquals("champs", cohort.getCohortName());
    }

    }
