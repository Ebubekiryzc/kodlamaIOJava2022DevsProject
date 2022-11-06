package kodlama.io.devs.business.responses.programmingtechnology;

import lombok.Data;

@Data
public class GetByIdProgrammingTechnologyResponse {
    private Long id;
    private String programmingLanguageName;
    private String programmingTechnologyTypeName;
    private String name;
}
