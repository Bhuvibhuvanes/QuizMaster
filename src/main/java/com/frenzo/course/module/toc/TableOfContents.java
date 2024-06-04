package com.frenzo.course.module.toc;

import com.frenzo.course.module.lesson.Lesson;
import com.frenzo.courses.Course;

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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class TableOfContents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "content", nullable = false)
    private int content;

    // Assuming you have defined TocContentEntity as a superclass for Topic, GradedQuiz, Exercise, and Poll entities
//    @ManyToOne
//    @JoinColumn(name = "content_id", nullable = false)
//    private TocContentEntity contentObject;

}
