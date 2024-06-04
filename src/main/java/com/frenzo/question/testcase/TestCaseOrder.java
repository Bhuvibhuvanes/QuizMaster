package com.frenzo.question.testcase;

import com.frenzo.course.module.quiz.questionpaper.answerpaper.AnswerPaper;
import com.frenzo.questions.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TestCaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "answer_paper_id")
    private AnswerPaper answerPaper;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @Column(name = "\"order\"", columnDefinition = "TEXT")
    private String order;

}
