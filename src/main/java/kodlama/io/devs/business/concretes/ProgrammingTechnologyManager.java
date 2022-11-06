package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.devs.business.abstracts.ProgrammingTechnologyTypeService;
import kodlama.io.devs.business.customannotations.ValidateRequest;
import kodlama.io.devs.business.mapper.programmingtechnology.ProgrammingTechnologyMapper;
import kodlama.io.devs.business.requests.programmingtechnology.CreateProgrammingTechnologyRequest;
import kodlama.io.devs.business.requests.programmingtechnology.UpdateProgrammingTechnologyRequest;
import kodlama.io.devs.business.responses.programminglanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.devs.business.responses.programmingtechnology.*;
import kodlama.io.devs.business.responses.programmingtechnologytype.GetByIdProgrammingTechnologyTypeResponse;
import kodlama.io.devs.business.rules.ProgrammingTechnologyBusinessRules;
import kodlama.io.devs.dataaccess.abstracts.ProgrammingTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.ProgrammingTechnology;
import kodlama.io.devs.entities.concretes.ProgrammingTechnologyType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

    private final ProgrammingTechnologyRepository programmingTechnologyRepository;
    private final ProgrammingTechnologyTypeService programmingTechnologyTypeService;
    private final ProgrammingLanguageService programmingLanguageService;
    private final ProgrammingTechnologyMapper mapper;
    private final ProgrammingTechnologyBusinessRules businessRules;

    @Override
    public List<GetAllProgrammingTechnologiesResponse> getAll() {
        return programmingTechnologyRepository.findAll().stream()
                .map(p -> mapper.programmingTechnologyToGetAllProgrammingTechnologiesResponse(p))
                .collect(Collectors.toList());
    }

    @Override
    public GetByIdProgrammingTechnologyResponse getById(Long id) {
        businessRules.programmingTechnologyMustExistWhenRequested(id);
        return mapper.programmingTechnologyToGetByIdProgrammingTechnologyResponse(programmingTechnologyRepository.findById(id).get());
    }

    @Override
    @ValidateRequest
    public CreateProgrammingTechnologyResponse create(CreateProgrammingTechnologyRequest request) {
        ProgrammingTechnology programmingTechnology = mapper.createProgrammingTechnologyRequestToProgrammingTechnology(request);
        businessRules.programmingTechnologyNameMustBeUniqueWhenCreating(programmingTechnology);

        GetByIdProgrammingTechnologyTypeResponse getByIdProgrammingTechnologyTypeResponse = programmingTechnologyTypeService
                .getById(request.getProgrammingTechnologyTypeId());

        ProgrammingTechnologyType programmingTechnologyType = new ProgrammingTechnologyType(
                getByIdProgrammingTechnologyTypeResponse.getId(),
                getByIdProgrammingTechnologyTypeResponse.getName(),
                getByIdProgrammingTechnologyTypeResponse.getProgrammingTechnologies());

        GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = programmingLanguageService.getById(request.getProgrammingLanguageId());
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(
                getByIdProgrammingLanguageResponse.getId(),
                getByIdProgrammingLanguageResponse.getName(),
                getByIdProgrammingLanguageResponse.getProgrammingTechnologies()
        );

        programmingTechnology.setProgrammingTechnologyType(programmingTechnologyType);
        programmingTechnology.setProgrammingLanguage(programmingLanguage);
        return mapper.programmingTechnologyToCreateProgrammingTechnologyResponse(programmingTechnologyRepository.save(programmingTechnology));
    }

    @Override
    @ValidateRequest
    public UpdateProgrammingTechnologyResponse update(UpdateProgrammingTechnologyRequest request) {
        businessRules.programmingTechnologyMustExistWhenRequested(request.getId());
        ProgrammingTechnology programmingTechnologyToUpdate = programmingTechnologyRepository.findById(request.getId()).get();

        ProgrammingTechnology programmingTechnology = mapper.updateProgrammingTechnologyRequestToProgrammingTechnology(request);
        businessRules.programmingTechnologyNameMustBeUniqueWhenUpdating(programmingTechnology);

        if (programmingTechnologyToUpdate.getProgrammingTechnologyType().getId() != request.getProgrammingTechnologyTypeId()) {
            GetByIdProgrammingTechnologyTypeResponse getByIdProgrammingTechnologyTypeResponse = programmingTechnologyTypeService
                    .getById(programmingTechnology.getProgrammingTechnologyType().getId());

            ProgrammingTechnologyType programmingTechnologyType = new ProgrammingTechnologyType(
                    getByIdProgrammingTechnologyTypeResponse.getId(),
                    getByIdProgrammingTechnologyTypeResponse.getName(),
                    getByIdProgrammingTechnologyTypeResponse.getProgrammingTechnologies());

            programmingTechnologyToUpdate.setProgrammingTechnologyType(programmingTechnologyType);
        }
        if (programmingTechnologyToUpdate.getProgrammingLanguage().getId() != request.getProgrammingLanguageId()) {
            GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = programmingLanguageService
                    .getById(programmingTechnology.getProgrammingLanguage().getId());

            ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(
                    getByIdProgrammingLanguageResponse.getId(),
                    getByIdProgrammingLanguageResponse.getName(),
                    getByIdProgrammingLanguageResponse.getProgrammingTechnologies()
            );

            programmingTechnologyToUpdate.setProgrammingLanguage(programmingLanguage);
        }

        programmingTechnologyToUpdate.setName(programmingTechnology.getName());
        return mapper.programmingTechnologyToUpdateProgrammingTechnologyResponse(programmingTechnologyRepository.save(programmingTechnologyToUpdate));
    }

    @Override
    public DeleteProgrammingTechnologyResponse deleteById(Long id) {
        businessRules.programmingTechnologyMustExistWhenRequested(id);

        ProgrammingTechnology programmingTechnology = programmingTechnologyRepository.findById(id).get();
        programmingTechnologyRepository.deleteById(programmingTechnology.getId());
        return mapper.programmingTechnologyToDeleteProgrammingTechnologyResponse(programmingTechnology);
    }
}
