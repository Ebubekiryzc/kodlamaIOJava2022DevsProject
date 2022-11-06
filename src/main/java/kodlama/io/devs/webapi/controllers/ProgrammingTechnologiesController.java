package kodlama.io.devs.webapi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.devs.business.requests.programmingtechnology.CreateProgrammingTechnologyRequest;
import kodlama.io.devs.business.requests.programmingtechnology.UpdateProgrammingTechnologyRequest;
import kodlama.io.devs.business.responses.programmingtechnology.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingTechnologies")
@RequiredArgsConstructor
public class ProgrammingTechnologiesController {

    private final ProgrammingTechnologyService programmingTechnologyService;

    @GetMapping
    public List<GetAllProgrammingTechnologiesResponse> getAll() {
        return programmingTechnologyService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingTechnologyResponse getById(@PathVariable("id") Long id) {
        return programmingTechnologyService.getById(id);
    }

    @PostMapping
    public CreateProgrammingTechnologyResponse create(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) {
        return programmingTechnologyService.create(createProgrammingTechnologyRequest);
    }

    @PutMapping
    public UpdateProgrammingTechnologyResponse update(UpdateProgrammingTechnologyRequest request) {
        return programmingTechnologyService.update(request);
    }

    @DeleteMapping("/{id}")
    public DeleteProgrammingTechnologyResponse delete(@PathVariable("id") Long id) {
        return programmingTechnologyService.deleteById(id);
    }
}
