package africa.semicolon.eregister.service;

import africa.semicolon.eregister.dtos.NativeRequestDto;
import africa.semicolon.eregister.dtos.NativeResponseDto;
import africa.semicolon.eregister.model.Native;
import africa.semicolon.eregister.model.enums.Gender;
import africa.semicolon.eregister.repository.NativeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NativeServiceImplTest {

    @Autowired
    private NativeRepository nativeRepository;

    @Autowired
    private NativeService nativeService;

    @BeforeEach
    void setup(){
        nativeRepository.deleteAll();
    }

    @Test
    void addNativeTest(){

        NativeRequestDto nativeRequestDto = new NativeRequestDto("sam", "ade", Gender.MALE, "dekanorbs");

        NativeResponseDto savedNative = nativeService.save(nativeRequestDto);

        assertEquals(1, nativeRepository.count());
        assertEquals(savedNative.getFirstName(), nativeRepository.findById(savedNative.getId()).get().getFirstName());
    }

    @Test
    void getAllCohort(){
        NativeRequestDto nativeRequestDto = new NativeRequestDto("sam", "ade", Gender.MALE, "dekanorbs");
        NativeRequestDto nativeRequestDto1 = new NativeRequestDto("Joe", "blogs", Gender.FEMALE, "luminaries");
        NativeRequestDto nativeRequestDto2 = new NativeRequestDto("sham", "ordinaka", Gender.MALE, "dekanorbs");

        nativeService.save(nativeRequestDto);
        nativeService.save(nativeRequestDto1);
        nativeService.save(nativeRequestDto2);

        assertEquals(3, nativeRepository.count());
    }

    @Test
    void deleteById(){
        NativeRequestDto nativeRequestDto = new NativeRequestDto("sam", "ade", Gender.MALE, "dekanorbs");
        NativeRequestDto nativeRequestDto1 = new NativeRequestDto("Joe", "blogs", Gender.FEMALE, "luminaries");
        NativeRequestDto nativeRequestDto2 = new NativeRequestDto("sham", "ordinaka", Gender.MALE, "dekanorbs");

        NativeResponseDto savedNative3 = nativeService.save(nativeRequestDto);
        NativeResponseDto savedNative4 = nativeService.save(nativeRequestDto1);
        NativeResponseDto savedNative5 = nativeService.save(nativeRequestDto2);

        nativeService.deleteNative(savedNative3.getId());

        assertEquals(2, nativeRepository.count());
    }

    @Test
    void getAllNativeByCohortName(){
        NativeRequestDto nativeRequestDto = new NativeRequestDto("sam", "ade", Gender.MALE, "dekanorbs");
        NativeRequestDto nativeRequestDto1 = new NativeRequestDto("Joe", "blogs", Gender.FEMALE, "luminaries");
        NativeRequestDto nativeRequestDto2 = new NativeRequestDto("sham", "ordinaka", Gender.MALE, "dekanorbs");

        NativeResponseDto savedNative3 = nativeService.save(nativeRequestDto);
        NativeResponseDto savedNative4 = nativeService.save(nativeRequestDto1);
        NativeResponseDto savedNative5 = nativeService.save(nativeRequestDto2);



    }

}
