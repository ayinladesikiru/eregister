package africa.semicolon.eregister.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CohortResponseDto {
    private  Long id;
    private String cohortName;
    private String cohortNumber;
}
