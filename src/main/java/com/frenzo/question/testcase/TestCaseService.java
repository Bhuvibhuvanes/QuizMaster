package com.frenzo.question.testcase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService {
    @Autowired
    TestCaseRepo testCaseRepo;

    public List<TestCase> getTestCases() {
        List<TestCase> testCases = testCaseRepo.findAll();
        if (!testCases.isEmpty()) {
            return testCases;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public TestCase addTestCase(TestCase testCase) {
        return testCaseRepo.save(testCase);
    }

    public void deleteTestCase(int id) {
        testCaseRepo.deleteById(id);
    }

    public TestCase getTestCaseById(int id) {
        Optional<TestCase> testCase = testCaseRepo.findById(id);
        if (testCase.isPresent()) {
            return testCase.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public TestCase updateTestCase(int id, TestCase updatedTestCase) {
        return testCaseRepo.findById(id).map(existingTestCase -> {
            updatedTestCase.setId(existingTestCase.getId());
            return testCaseRepo.save(updatedTestCase);
        }).orElseThrow(() -> new RuntimeException("TestCase with ID " + id + " not found"));
    }
}
