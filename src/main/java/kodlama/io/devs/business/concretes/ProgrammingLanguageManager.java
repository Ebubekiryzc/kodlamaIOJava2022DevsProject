package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.mapper.programminglanguage.ProgrammingLanguageMapper;
import kodlama.io.devs.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programminglanguage.*;
import kodlama.io.devs.business.rules.ProgrammingLanguageBusinessRules;
import kodlama.io.devs.dataaccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final ProgrammingLanguageRepository programmingLanguageRepository;
    private final ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;
    private final ProgrammingLanguageMapper programmingLanguageMapper;

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return programmingLanguageRepository.findAll().stream()
                .map(p -> programmingLanguageMapper.programmingLanguageToGetAllProgrammingLanguagesResponse(p))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(Long id) {
        programmingLanguageBusinessRules.programmingLanguageMustExistWhenRequested(id);
        return programmingLanguageMapper
                .programmingLanguageToGetByIdProgrammingLanguageResponse(programmingLanguageRepository.findById(id).get());
    }

    @Override
    public CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createRequest) {
        ProgrammingLanguage programmingLanguage = programmingLanguageMapper
                .createProgrammingLanguageRequestToProgrammingLanguage(createRequest);

        programmingLanguageBusinessRules.programmingLanguageNameMustBeUniqueWhenCreating(programmingLanguage);

        return programmingLanguageMapper.programmingLanguageToCreateProgrammingLanguageResponse(
                programmingLanguageRepository.save(programmingLanguage)
        );
    }

    @Override
    public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateRequest) {
        programmingLanguageBusinessRules.programmingLanguageMustExistWhenRequested(updateRequest.getId());

        ProgrammingLanguage programmingLanguage = programmingLanguageMapper
                .updateProgrammingLanguageRequestToProgrammingLanguage(updateRequest);

        programmingLanguageBusinessRules.programmingLanguageNameMustBeUniqueWhenUpdating(programmingLanguage);

        return programmingLanguageMapper.programmingLanguageToUpdateProgrammingLanguageResponse(
                programmingLanguageRepository.save(programmingLanguage)
        );
    }

    @Override
    public DeleteProgrammingLanguageResponse deleteById(Long id) {
        programmingLanguageBusinessRules.programmingLanguageMustExistWhenRequested(id);

        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
        programmingLanguageRepository.deleteById(programmingLanguage.getId());
        return programmingLanguageMapper.programmingLanguageToDeleteProgrammingLanguageResponse(programmingLanguage);
    }
}
