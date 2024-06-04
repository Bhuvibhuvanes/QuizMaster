package com.frenzo.assignment;

import java.sql.Date;

import com.frenzo.course.module.quiz.questionpaper.answerpaper.AnswerPaper;
import com.frenzo.questions.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AssignmentUpload {

    @Id
    @GeneratedValue
    (strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "assignment_question_id", nullable = false)
    private Question assignmentQuestion;

    private String assignmentFile;

    @ManyToOne
    @JoinColumn(name = "answer_paper_id")
    private AnswerPaper answerPaper;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_date", nullable = false)
    private Date uploadDate;

}