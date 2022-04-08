package br.com.meli.qatestingproject.controller;

import br.com.meli.qatestingproject.dto.TestcaseRequest;
import br.com.meli.qatestingproject.entity.TestCase;
import br.com.meli.qatestingproject.service.TestCaseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
@AllArgsConstructor
public class TestCaseController {

    private final TestCaseService testCaseService;
    private final ModelMapper modelMapper;

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody TestcaseRequest testcaseRequest) {
        TestCase testCase = modelMapper.map(testcaseRequest, TestCase.class);
        TestCase savedTestCase = testCaseService.save(testCase);
        return ResponseEntity.created(URI.create("/" + savedTestCase.getId())).body(savedTestCase);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<TestCase> testCases = testCaseService.findAll();
        return ResponseEntity.ok(testCases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        TestCase testCase = testCaseService.findById(id);
        return ResponseEntity.ok(testCase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TestcaseRequest testcaseRequest) {
        TestCase testCase = modelMapper.map(testcaseRequest, TestCase.class);
        TestCase updatedTestCase = testCaseService.update(id, testCase);
        return ResponseEntity.ok(updatedTestCase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        testCaseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
