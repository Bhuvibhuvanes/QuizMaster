package com.frenzo.course.module.quiz.questionpaper.question.answer;

import com.frenzo.questions.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "answer", columnDefinition = "TEXT", nullable = true)
    private String answer;

    @Column(name = "error", columnDefinition = "TEXT")
    private String error;

    private float marks = 0.0f;

    private boolean correct = false;

    private boolean skipped = false;

    @Column(name = "comment", columnDefinition = "TEXT", nullable = true)
    private String comment;
}