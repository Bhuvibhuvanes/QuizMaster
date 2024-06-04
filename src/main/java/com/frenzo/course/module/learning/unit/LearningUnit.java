package com.frenzo.course.module.learning.unit;


import com.frenzo.course.module.lesson.Lesson;
import com.frenzo.course.module.quizs.Quiz;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "learningunits")
public class LearningUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "\"order\"")
    private int order;

    private String type;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = true)
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = true)
    private Quiz quiz;

    private boolean checkPrerequisite;
}
