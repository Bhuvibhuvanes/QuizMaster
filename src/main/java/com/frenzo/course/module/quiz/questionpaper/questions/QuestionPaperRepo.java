package com.frenzo.course.module.quiz.questionpaper.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPaperRepo extends JpaRepository<QuestionPaper, Integer> {
}
