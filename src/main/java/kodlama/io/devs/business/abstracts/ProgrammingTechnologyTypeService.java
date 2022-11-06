package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.programmingtechnologytype.CreateProgrammingTechnologyTypeRequest;
import kodlama.io.devs.business.requests.programmingtechnologytype.UpdateProgrammingTechnologyTypeRequest;
import kodlama.io.devs.business.responses.programmingtechnologytype.*;

import java.util.List;

public interface ProgrammingTechnologyTypeService {
    List<GetAllProgrammingTechnologyTypesResponse> getAll();

    GetByIdProgrammingTechnologyTypeResponse getById(Long id);

    CreateProgrammingTechnologyTypeResponse create(CreateProgrammingTechnologyTypeRequest request);

    UpdateProgrammingTechnologyTypeResponse update(UpdateProgrammingTechnologyTypeRequest request);

    DeleteProgrammingTechnologyTypeResponse deleteById(Long id);
}
