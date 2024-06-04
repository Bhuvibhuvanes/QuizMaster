package com.frenzo.course.modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/learning-modules")
public class LearningModuleController {
    @Autowired
    LearningModuleService learningModuleService;

    @PostMapping
    public ResponseEntity<LearningModule> addLearningModule(@RequestBody LearningModule learningModule) {
        LearningModule addedLearningModule = learningModuleService.addLearningModule(learningModule);
        return new ResponseEntity<>(addedLearningModule, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningModule>> getLearningModules() {
        List<LearningModule> learningModules = learningModuleService.getLearningModules();
        return new ResponseEntity<>(learningModules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningModule> getLearningModuleById(@PathVariable("id") int id) {
        LearningModule learningModule = learningModuleService.getLearningModuleById(id);
        return new ResponseEntity<>(learningModule, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningModule> updateLearningModule(@PathVariable int id, @RequestBody LearningModule learningModule) {
        LearningModule updatedLearningModule = learningModuleService.updateLearningModule(id, learningModule);
        return new ResponseEntity<>(updatedLearningModule, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteLearningModule(@PathVariable int id) throws NotFoundException {
        learningModuleService.deleteLearningModule(id);
        return HttpStatus.OK;
    }
}