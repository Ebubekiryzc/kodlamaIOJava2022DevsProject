package kodlama.io.devs.business.rules;

import kodlama.io.devs.dataaccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingLanguageBusinessRules {

    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public void programmingLanguageNameMustBeUniqueWhenCreating(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage existence = programmingLanguageRepository.getAll().stream().filter(p -> p.getName().equalsIgnoreCase(programmingLanguage.getName())).findAny().orElse(null);
        if (existence != null) throw new RuntimeException("Programming Language name exist.");
    }

    public void programmingLanguageNameMustBeUniqueWhenUpdating(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage existence = programmingLanguageRepository.getAll().stream().filter(p -> p.getName().equalsIgnoreCase(programmingLanguage.getName()) && p.getId() != programmingLanguage.getId()).findAny().orElse(null);
        if (existence != null) throw new RuntimeException("Programming Language name exist.");
    }
}
