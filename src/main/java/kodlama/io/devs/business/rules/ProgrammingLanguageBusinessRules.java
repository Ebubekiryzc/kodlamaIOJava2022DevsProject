package kodlama.io.devs.business.rules;

import kodlama.io.devs.dataaccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.exception.classes.ProgrammingLanguageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgrammingLanguageBusinessRules {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public void programmingLanguageNameMustBeUniqueWhenCreating(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage existence = programmingLanguageRepository.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(programmingLanguage.getName())).findAny().orElse(null);
        if (existence != null) throw new RuntimeException("Programming Language name exist.");
    }

    public void programmingLanguageNameMustBeUniqueWhenUpdating(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage existence = programmingLanguageRepository.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(programmingLanguage.getName()) && p.getId() != programmingLanguage.getId()).findAny().orElse(null);
        if (existence != null) throw new RuntimeException("Programming Language name exist.");
    }

    public void programmingLanguageMustExistWhenRequested(Long id) {
        programmingLanguageRepository
                .findById(id).orElseThrow(() -> new ProgrammingLanguageNotFoundException("Requested programming language does not exist."));
    }
}
