package com.frenzo.course.module.quiz.questionpaper.answerpaper;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.frenzo.course.module.quiz.questionpaper.question.answer.Answer;
import com.frenzo.course.module.quiz.questionpaper.questions.QuestionPaper;
import com.frenzo.courses.Course;
import com.frenzo.entity.UserInfo;
import com.frenzo.questions.Question;

import jakarta.persistence.Column;
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
@Table(name = "answer_paper")
public class AnswerPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;

    @ManyToMany
    @JoinTable(
        name = "answer_paper_questions",
        joinColumns = @JoinColumn(name = "answer_paper_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> questions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "question_paper_id", nullable = false)
    private QuestionPaper questionPaper;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "attempt_number", nullable = false)
    private int attemptNumber;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "user_ip", length = 255)
    private String userIp;

    @ManyToMany
    @JoinTable(
        name = "questions_unanswered",
        joinColumns = @JoinColumn(name = "answer_paper_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> questionsUnanswered = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "questions_answered",
        joinColumns = @JoinColumn(name = "answer_paper_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> questionsAnswered = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "answer_paper_answers",
        joinColumns = @JoinColumn(name = "answer_paper_id"),
        inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<Answer> answers = new HashSet<>();

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @Column(name = "marks_obtained", nullable = true)
    private Float marksObtained;

    @Column(name = "percent", nullable = true)
    private Float percent;

    private Boolean passed;

    private String status;

    @Column(name = "questions_order", columnDefinition = "TEXT")
    private String questionsOrder;

    private float extraTime;

    private boolean isSpecial;

//    @ManyToOne
//    @JoinColumn(name = "answer_paper_manager_id", nullable = false)
//    private AnswerPaperManager answerPaperManager;

}
