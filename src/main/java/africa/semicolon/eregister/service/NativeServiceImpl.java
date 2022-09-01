package africa.semicolon.eregister.service;

import africa.semicolon.eregister.dtos.CohortRequestDto;
import africa.semicolon.eregister.dtos.CohortResponseDto;
import africa.semicolon.eregister.dtos.NativeRequestDto;
import africa.semicolon.eregister.dtos.NativeResponseDto;
import africa.semicolon.eregister.model.Cohort;
import africa.semicolon.eregister.model.Native;
import africa.semicolon.eregister.repository.CohortRepository;
import africa.semicolon.eregister.repository.NativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class NativeServiceImpl implements NativeService {

    @Autowired
    private NativeRepository nativeRepository;

    @Autowired
    private CohortRepository cohortRepository;

    @Override
    public NativeResponseDto save(NativeRequestDto nativeRequestDto) {
        Cohort cohort = cohortRepository.findByCohortName(nativeRequestDto.getCohortName());
        Native aNative = new Native();
        aNative.setFirstName(nativeRequestDto.getFirstName());
        aNative.setLastName(nativeRequestDto.getLastName());
        aNative.setGender(nativeRequestDto.getGender());
        aNative.setCohort(cohort);
        Native savedNative = nativeRepository.save(aNative);
        return NativeResponseDto
                .builder()
                .id(savedNative.getId())
                .firstName(savedNative.getFirstName())
                .lastName(savedNative.getLastName())
                .cohort(savedNative.getCohort())
                .msg("Successfully saved")
                .build();
    }

    @Override
    public List<Native> getAllNative() {
        return new ArrayList<>(nativeRepository.findAll());
    }

    @Override
    public List<Native> getAllNativeByCohortName(String cohortname) {
        return new ArrayList<>((Collection) nativeRepository.findAllByCohort(cohortname));
    }


    @Override
    public void deleteNative(Long id) {
        nativeRepository.deleteById(id);
    }


}
