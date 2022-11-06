package kodlama.io.devs.business.mapper.programmingtechnology;

import kodlama.io.devs.business.requests.programmingtechnology.CreateProgrammingTechnologyRequest;
import kodlama.io.devs.business.requests.programmingtechnology.UpdateProgrammingTechnologyRequest;
import kodlama.io.devs.business.responses.programmingtechnology.*;
import kodlama.io.devs.entities.concretes.ProgrammingTechnology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProgrammingTechnologyMapper {

    @Mapping(source = "programmingTechnologyTypeId", target = "programmingTechnologyType.id")
    @Mapping(source = "programmingLanguageId", target = "programmingLanguage.id")
    ProgrammingTechnology createProgrammingTechnologyRequestToProgrammingTechnology(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest);

    @Mapping(source = "programmingTechnologyTypeId", target = "programmingTechnologyType.id")
    @Mapping(source = "programmingLanguageId", target = "programmingLanguage.id")
    ProgrammingTechnology updateProgrammingTechnologyRequestToProgrammingTechnology(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest);

    @Mapping(source = "programmingTechnologyType.name", target = "programmingTechnologyTypeName")
    @Mapping(source = "programmingLanguage.name", target = "programmingLanguageName")
    GetAllProgrammingTechnologiesResponse programmingTechnologyToGetAllProgrammingTechnologiesResponse(ProgrammingTechnology programmingTechnology);

    @Mapping(source = "programmingTechnologyType.name", target = "programmingTechnologyTypeName")
    @Mapping(source = "programmingLanguage.name", target = "programmingLanguageName")
    GetByIdProgrammingTechnologyResponse programmingTechnologyToGetByIdProgrammingTechnologyResponse(ProgrammingTechnology programmingTechnology);

    @Mapping(source = "programmingTechnologyType.name", target = "programmingTechnologyTypeName")
    @Mapping(source = "programmingLanguage.name", target = "programmingLanguageName")
    CreateProgrammingTechnologyResponse programmingTechnologyToCreateProgrammingTechnologyResponse(ProgrammingTechnology programmingTechnology);

    @Mapping(source = "programmingTechnologyType.name", target = "programmingTechnologyTypeName")
    @Mapping(source = "programmingLanguage.name", target = "programmingLanguageName")
    UpdateProgrammingTechnologyResponse programmingTechnologyToUpdateProgrammingTechnologyResponse(ProgrammingTechnology programmingTechnology);

    @Mapping(source = "programmingTechnologyType.name", target = "programmingTechnologyTypeName")
    @Mapping(source = "programmingLanguage.name", target = "programmingLanguageName")
    DeleteProgrammingTechnologyResponse programmingTechnologyToDeleteProgrammingTechnologyResponse(ProgrammingTechnology programmingTechnology);
}
