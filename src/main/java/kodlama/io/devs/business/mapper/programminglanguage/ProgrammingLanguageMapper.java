package kodlama.io.devs.business.mapper.programminglanguage;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.webapi.requests.programminglanguage.ProgrammingLanguageCreateRequest;
import kodlama.io.devs.webapi.requests.programminglanguage.ProgrammingLanguageUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgrammingLanguageMapper {
    ProgrammingLanguage programmingLanguageCreateRequestToProgrammingLanguage(ProgrammingLanguageCreateRequest programmingLanguageCreateRequest);

    ProgrammingLanguage programmingLanguageUpdateRequestToProgrammingLanguage(ProgrammingLanguageUpdateRequest programmingLanguageUpdateRequest);
}
