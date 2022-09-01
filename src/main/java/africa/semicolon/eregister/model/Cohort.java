package africa.semicolon.eregister.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@ToString
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String cohortName;
    private String cohortNumber;


    @PostPersist
    public void createCohortName(){
        this.cohortNumber = "Cohort " + this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cohort cohort = (Cohort) o;
        return id != null && Objects.equals(id, cohort.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
