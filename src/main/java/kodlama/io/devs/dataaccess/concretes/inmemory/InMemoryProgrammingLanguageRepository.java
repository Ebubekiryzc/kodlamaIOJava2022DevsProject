package kodlama.io.devs.dataaccess.concretes.inmemory;

import kodlama.io.devs.dataaccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    private List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<>();
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(Long id) {
        return programmingLanguages.stream()
                .filter(programmingLanguage -> programmingLanguage.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public ProgrammingLanguage create(ProgrammingLanguage programmingLanguage) {
        programmingLanguage.setId(Long.valueOf(programmingLanguages.size() + 1));
        programmingLanguages.add(programmingLanguage);
        return programmingLanguage;
    }

    @Override
    public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage programmingLanguageToUpdate = getById(programmingLanguage.getId());
        programmingLanguageToUpdate.setName(programmingLanguage.getName());
        return programmingLanguageToUpdate;
    }

    @Override
    public void deleteById(Long id) {
        programmingLanguages.removeIf(programmingLanguage -> programmingLanguage.getId() == id);
    }
}
