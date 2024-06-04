package com.frenzo.course.module.learning.unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class LearningUnitService {
    @Autowired
    LearningUnitRepo learningUnitRepo;

    public List<LearningUnit> getLearningUnits() {
        List<LearningUnit> learningUnits = learningUnitRepo.findAll();
        if (!learningUnits.isEmpty()) {
            return learningUnits;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public LearningUnit addLearningUnit(LearningUnit learningUnit) {
        return learningUnitRepo.save(learningUnit);
    }

    public void deleteLearningUnit(int id) {
        learningUnitRepo.deleteById(id);
    }

    public LearningUnit getLearningUnitById(int id) {
        Optional<LearningUnit> learningUnit = learningUnitRepo.findById(id);
        if (learningUnit.isPresent()) {
            return learningUnit.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public LearningUnit updateLearningUnit(int id, LearningUnit updatedLearningUnit) {
        return learningUnitRepo.findById(id).map(existingLearningUnit -> {
            updatedLearningUnit.setId(existingLearningUnit.getId());
            return learningUnitRepo.save(updatedLearningUnit);
        }).orElseThrow(() -> new RuntimeException("Learning Unit with ID " + id + " not found"));
    }
}
