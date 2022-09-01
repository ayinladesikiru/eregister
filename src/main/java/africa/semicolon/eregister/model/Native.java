package africa.semicolon.eregister.model;

import africa.semicolon.eregister.model.enums.Gender;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Native {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String firstName;
    private String lastName;
    private Gender gender;


    @ManyToOne()
    private Cohort cohort;

}
