package com.frenzo.course.modules;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

@Service
public class LearningModuleService {
    @Autowired
    LearningModuleRepo learningModuleRepo;

    public List<LearningModule> getLearningModules() {
        List<LearningModule> learningModules = learningModuleRepo.findAll();
        if (!learningModules.isEmpty()) {
            return learningModules;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public LearningModule addLearningModule(LearningModule learningModule) {
        return learningModuleRepo.save(learningModule);
    }

    public void deleteLearningModule(int id) {
        learningModuleRepo.deleteById(id);
    }

    public LearningModule getLearningModuleById(int id) {
        Optional<LearningModule> learningModule = learningModuleRepo.findById(id);
        if (learningModule.isPresent()) {
            return learningModule.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public LearningModule updateLearningModule(int id, LearningModule updatedLearningModule) {
        return learningModuleRepo.findById(id).map(existingLearningModule -> {
            updatedLearningModule.setId(existingLearningModule.getId());
            return learningModuleRepo.save(updatedLearningModule);
        }).orElseThrow(() -> new RuntimeException("Learning Module with ID " + id + " not found"));
    }
}