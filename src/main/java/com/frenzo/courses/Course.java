package com.frenzo.courses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.frenzo.course.modules.LearningModule;
import com.frenzo.entity.UserInfo;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String enrollment;

    private boolean active = true;

    private String code;

    private boolean hidden = false;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private UserInfo creator;

    @ManyToMany
    @JoinTable(
        name = "course_students",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<UserInfo> students = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "course_requests",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "request_id")
    )
    private List<UserInfo> requests = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "course_rejected",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "rejected_id")
    )
    private List<UserInfo> rejected = new ArrayList<>();

    private LocalDateTime createdOn = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
        name = "course_teachers",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<UserInfo> teachers = new ArrayList<>();

    private boolean isTrial = false;

    private String instructions;

    private boolean viewGrade = false;

    @ManyToMany
    @JoinTable(
        name = "course_learning_modules",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "learning_module_id")
    )
    private List<LearningModule> learningModules = new ArrayList<>();

    private LocalDateTime startEnrollTime = LocalDateTime.now();

    private LocalDateTime endEnrollTime = LocalDateTime.of(2199, 1, 1, 0, 0);

//    @ManyToOne
//    @JoinColumn(name = "grading_system_id", nullable = true)
//    private GradingSystem gradingSystem;
}