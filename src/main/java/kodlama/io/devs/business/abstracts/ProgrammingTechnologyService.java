package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.programmingtechnology.CreateProgrammingTechnologyRequest;
import kodlama.io.devs.business.requests.programmingtechnology.UpdateProgrammingTechnologyRequest;
import kodlama.io.devs.business.responses.programmingtechnology.*;

import java.util.List;

public interface ProgrammingTechnologyService {
    List<GetAllProgrammingTechnologiesResponse> getAll();

    GetByIdProgrammingTechnologyResponse getById(Long id);

    CreateProgrammingTechnologyResponse create(CreateProgrammingTechnologyRequest request);

    UpdateProgrammingTechnologyResponse update(UpdateProgrammingTechnologyRequest request);

    DeleteProgrammingTechnologyResponse deleteById(Long id);
}
