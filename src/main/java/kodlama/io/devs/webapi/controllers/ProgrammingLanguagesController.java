package kodlama.io.devs.webapi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.mapper.programminglanguage.ProgrammingLanguageMapper;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.webapi.requests.programminglanguage.ProgrammingLanguageCreateRequest;
import kodlama.io.devs.webapi.requests.programminglanguage.ProgrammingLanguageUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

    @Autowired
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    private ProgrammingLanguageMapper programmingLanguageMapper;

    @GetMapping
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable("id") Long id) {
        return programmingLanguageService.getById(id);
    }

    @PostMapping
    public ProgrammingLanguage create(@RequestBody ProgrammingLanguageCreateRequest programmingLanguageCreateRequest) {
        return programmingLanguageService.create(programmingLanguageMapper.programmingLanguageCreateRequestToProgrammingLanguage(programmingLanguageCreateRequest));
    }

    @PutMapping
    public ProgrammingLanguage update(@RequestBody ProgrammingLanguageUpdateRequest programmingLanguageUpdateRequest) {
        return programmingLanguageService.update(programmingLanguageMapper.programmingLanguageUpdateRequestToProgrammingLanguage(programmingLanguageUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        programmingLanguageService.deleteById(id);
        return ResponseEntity.ok("Deleted successfully.");
    }

}
