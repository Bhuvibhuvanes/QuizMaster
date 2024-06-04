package com.frenzo.course.module.quiz.questionpaper.answerpaper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerPaperRepo extends JpaRepository<AnswerPaper, Integer> {


}
