package africa.semicolon.eregister.dtos;

import africa.semicolon.eregister.model.Cohort;
import africa.semicolon.eregister.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NativeRequestDto {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String cohortName;

}
