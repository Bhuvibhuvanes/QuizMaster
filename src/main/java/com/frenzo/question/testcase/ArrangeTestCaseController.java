package com.frenzo.question.testcase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
@RestController
@RequestMapping("/arrange-test-cases")
public class ArrangeTestCaseController {
    @Autowired
    ArrangeTestCaseService arrangeTestCaseService;

    @PostMapping
    public ResponseEntity<ArrangeTestCase> addArrangeTestCase(@RequestBody ArrangeTestCase arrangeTestCase) {
        ArrangeTestCase addedArrangeTestCase = arrangeTestCaseService.addArrangeTestCase(arrangeTestCase);
        return new ResponseEntity<>(addedArrangeTestCase, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ArrangeTestCase>> getArrangeTestCases() {
        List<ArrangeTestCase> arrangeTestCases = arrangeTestCaseService.getArrangeTestCases();
        return new ResponseEntity<>(arrangeTestCases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArrangeTestCase> getArrangeTestCaseById(@PathVariable("id") int id) {
        ArrangeTestCase arrangeTestCase = arrangeTestCaseService.getArrangeTestCaseById(id);
        return new ResponseEntity<>(arrangeTestCase, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArrangeTestCase> updateArrangeTestCase(@PathVariable int id, @RequestBody ArrangeTestCase arrangeTestCase) {
        ArrangeTestCase updatedArrangeTestCase = arrangeTestCaseService.updateArrangeTestCase(id, arrangeTestCase);
        return new ResponseEntity<>(updatedArrangeTestCase, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteArrangeTestCase(@PathVariable int id) throws NotFoundException {
        arrangeTestCaseService.deleteArrangeTestCase(id);
        return HttpStatus.OK;
    }
}