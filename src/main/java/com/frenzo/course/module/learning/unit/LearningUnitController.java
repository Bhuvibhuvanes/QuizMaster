package com.frenzo.course.module.learning.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/learning-units")
public class LearningUnitController {
    @Autowired
    LearningUnitService learningUnitService;

    @PostMapping
    public ResponseEntity<LearningUnit> addLearningUnit(@RequestBody LearningUnit learningUnit) {
        LearningUnit addedLearningUnit = learningUnitService.addLearningUnit(learningUnit);
        return new ResponseEntity<>(addedLearningUnit, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningUnit>> getLearningUnits() {
        List<LearningUnit> learningUnits = learningUnitService.getLearningUnits();
        return new ResponseEntity<>(learningUnits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningUnit> getLearningUnitById(@PathVariable("id") int id) {
        LearningUnit learningUnit = learningUnitService.getLearningUnitById(id);
        return new ResponseEntity<>(learningUnit, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningUnit> updateLearningUnit(@PathVariable int id, @RequestBody LearningUnit learningUnit) {
        LearningUnit updatedLearningUnit = learningUnitService.updateLearningUnit(id, learningUnit);
        return new ResponseEntity<>(updatedLearningUnit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteLearningUnit(@PathVariable int id) throws NotFoundException {
        learningUnitService.deleteLearningUnit(id);
        return HttpStatus.OK;
    }
}
