package kodlama.io.devs.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "programming_technology")
public class ProgrammingTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programming_technology_type_id", referencedColumnName = "id")
    @JsonBackReference
    private ProgrammingTechnologyType programmingTechnologyType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programming_language_id", referencedColumnName = "id")
    @JsonBackReference
    private ProgrammingLanguage programmingLanguage;
}
