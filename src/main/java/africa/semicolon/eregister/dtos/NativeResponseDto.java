package africa.semicolon.eregister.dtos;

import africa.semicolon.eregister.model.Cohort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NativeResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Cohort cohort;
    private String msg;

}
