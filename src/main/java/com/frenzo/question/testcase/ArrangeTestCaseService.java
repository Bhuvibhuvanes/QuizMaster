package com.frenzo.question.testcase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

@Service
public class ArrangeTestCaseService {
    @Autowired
    ArrangeTestCaseRepo arrangeTestCaseRepo;

    public List<ArrangeTestCase> getArrangeTestCases() {
        List<ArrangeTestCase> arrangeTestCases = arrangeTestCaseRepo.findAll();
        if (!arrangeTestCases.isEmpty()) {
            return arrangeTestCases;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public ArrangeTestCase addArrangeTestCase(ArrangeTestCase arrangeTestCase) {
        return arrangeTestCaseRepo.save(arrangeTestCase);
    }

    public void deleteArrangeTestCase(int id) {
        arrangeTestCaseRepo.deleteById(id);
    }

    public ArrangeTestCase getArrangeTestCaseById(int id) {
        Optional<ArrangeTestCase> arrangeTestCase = arrangeTestCaseRepo.findById(id);
        if (arrangeTestCase.isPresent()) {
            return arrangeTestCase.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public ArrangeTestCase updateArrangeTestCase(int id, ArrangeTestCase updatedArrangeTestCase) {
        return arrangeTestCaseRepo.findById(id).map(existingArrangeTestCase -> {
            updatedArrangeTestCase.setId(existingArrangeTestCase.getId());
            return arrangeTestCaseRepo.save(updatedArrangeTestCase);
        }).orElseThrow(() -> new RuntimeException("ArrangeTestCase with ID " + id + " not found"));
    }
}