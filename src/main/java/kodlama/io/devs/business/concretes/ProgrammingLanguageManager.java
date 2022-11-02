package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.rules.ProgrammingLanguageBusinessRules;
import kodlama.io.devs.dataaccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    private ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(Long id) {
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public ProgrammingLanguage create(ProgrammingLanguage programmingLanguage) {
        programmingLanguageBusinessRules.programmingLanguageNameMustBeUniqueWhenCreating(programmingLanguage);
        return programmingLanguageRepository.create(programmingLanguage);
    }

    @Override
    public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage) {
        programmingLanguageBusinessRules.programmingLanguageNameMustBeUniqueWhenUpdating(programmingLanguage);
        return programmingLanguageRepository.update(programmingLanguage);
    }

    @Override
    public void deleteById(Long id) {
        programmingLanguageRepository.deleteById(id);
    }
}
