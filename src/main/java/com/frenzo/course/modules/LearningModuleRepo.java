package com.frenzo.course.modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LearningModuleRepo extends JpaRepository<LearningModule, Integer> {
}