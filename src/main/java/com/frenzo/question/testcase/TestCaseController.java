package com.frenzo.question.testcase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/test-cases")
public class TestCaseController {
    @Autowired
    TestCaseService testCaseService;

    @PostMapping
    public ResponseEntity<TestCase> addTestCase(@RequestBody TestCase testCase) {
        TestCase addedTestCase = testCaseService.addTestCase(testCase);
        return new ResponseEntity<>(addedTestCase, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getTestCases() {
        List<TestCase> testCases = testCaseService.getTestCases();
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable("id") int id) {
        TestCase testCase = testCaseService.getTestCaseById(id);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> updateTestCase(@PathVariable int id, @RequestBody TestCase testCase) {
        TestCase updatedTestCase = testCaseService.updateTestCase(id, testCase);
        return new ResponseEntity<>(updatedTestCase, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTestCase(@PathVariable int id) throws NotFoundException {
        testCaseService.deleteTestCase(id);
        return HttpStatus.OK;
    }
}
