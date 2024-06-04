package com.frenzo.course.module.learning.unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningUnitRepo extends JpaRepository<LearningUnit, Integer> {
}
