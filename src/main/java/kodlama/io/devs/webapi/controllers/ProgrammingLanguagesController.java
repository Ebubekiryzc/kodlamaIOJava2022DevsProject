package kodlama.io.devs.webapi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programminglanguage.*;
import kodlama.io.devs.business.requests.programminglanguage.CreateProgrammingLanguageRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
@RequiredArgsConstructor
public class ProgrammingLanguagesController {

    private final ProgrammingLanguageService programmingLanguageService;

    @GetMapping
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdProgrammingLanguageResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(programmingLanguageService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CreateProgrammingLanguageResponse> create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        return ResponseEntity.ok(programmingLanguageService.create(createProgrammingLanguageRequest));
    }

    @PutMapping
    public ResponseEntity<UpdateProgrammingLanguageResponse> update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        return ResponseEntity.ok(programmingLanguageService.update(updateProgrammingLanguageRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProgrammingLanguageResponse> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(programmingLanguageService.deleteById(id));
    }

}
