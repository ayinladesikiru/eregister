package africa.semicolon.eregister.service;

import africa.semicolon.eregister.dtos.CohortRequestDto;
import africa.semicolon.eregister.dtos.CohortResponseDto;
import africa.semicolon.eregister.dtos.NativeRequestDto;
import africa.semicolon.eregister.dtos.NativeResponseDto;
import africa.semicolon.eregister.model.Cohort;
import africa.semicolon.eregister.model.Native;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface NativeService {

    NativeResponseDto save(NativeRequestDto nativeRequestDto);

    List<Native> getAllNative();

    List<Native> getAllNativeByCohortName(String cohortName);

    void deleteNative(Long id);

}
