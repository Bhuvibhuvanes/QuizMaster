package com.frenzo.course.module.quiz.questionpaper.questions;

import java.util.HashSet;
import java.util.Set;

import com.frenzo.course.module.quizs.Quiz;
import com.frenzo.model.QuestionSet;
import com.frenzo.questions.Question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "question_paper")
public class QuestionPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @ManyToMany
    @JoinTable(
        name = "question_paper_fixed_questions",
        joinColumns = @JoinColumn(name = "question_paper_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> fixedQuestions = new HashSet<>();
//
    @ManyToMany
    @JoinTable(
        name = "question_paper_random_questions",
        joinColumns = @JoinColumn(name = "question_paper_id"),
        inverseJoinColumns = @JoinColumn(name = "question_set_id")
    )
    private Set<QuestionSet> randomQuestions = new HashSet<>();
    

    private boolean shuffleQuestions = false;

    private float totalMarks = 0.0f;

    private String fixedQuestionOrder;

    private boolean shuffleTestcases = true;
}
