package kodlama.io.devs.business.responses.programmingtechnology;

import lombok.Data;

@Data
public class DeleteProgrammingTechnologyResponse {
    private Long id;
    private String programmingLanguageName;
    private String programmingTechnologyTypeName;
    private String name;
}
