package kodlama.io.devs.business.responses.programminglanguage;

import kodlama.io.devs.entities.concretes.ProgrammingTechnology;
import lombok.Data;

import java.util.List;

@Data
public class GetByIdProgrammingLanguageResponse {
    private Long id;
    private String name;
    private List<ProgrammingTechnology> programmingTechnologies;

}
