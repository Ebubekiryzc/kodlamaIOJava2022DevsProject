package kodlama.io.devs.dataaccess.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {
    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(Long id);

    ProgrammingLanguage create(ProgrammingLanguage programmingLanguage);

    ProgrammingLanguage update(ProgrammingLanguage programmingLanguage);

    void deleteById(Long id);
}
