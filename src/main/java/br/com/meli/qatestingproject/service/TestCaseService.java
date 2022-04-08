package br.com.meli.qatestingproject.service;

import br.com.meli.qatestingproject.entity.TestCase;
import br.com.meli.qatestingproject.repository.TestCaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestCaseService {

    private final TestCaseRepository testCaseRepository;

    public TestCase save(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public List<TestCase> findAll() {
        return testCaseRepository.findAll();
    }

    public TestCase findById(Long id) {
        return testCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("TestCase not found"));
    }

    public TestCase update(Long id, TestCase testCase) {
        TestCase oldTestCase = findById(id);
        oldTestCase.setTested(testCase.isTested());
        oldTestCase.setDescription(testCase.getDescription());
        oldTestCase.setLast_update(testCase.getLast_update());
        oldTestCase.setNumber_of_tries(testCase.getNumber_of_tries());
        return testCaseRepository.save(oldTestCase);
    }

    public void deleteById(Long id) {
        testCaseRepository.deleteById(id);
    }
}
