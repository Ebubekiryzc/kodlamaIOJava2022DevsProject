package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programminglanguage.*;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguagesResponse> getAll();

    GetByIdProgrammingLanguageResponse getById(Long id);

    CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createRequest);

    UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateRequest);

    DeleteProgrammingLanguageResponse deleteById(Long id);
}
