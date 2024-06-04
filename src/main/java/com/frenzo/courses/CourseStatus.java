package com.frenzo.courses;

import java.util.List;

import com.frenzo.course.module.learning.unit.LearningUnit;
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
@Table(name = "course_status")
public class CourseStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany
    @JoinTable(
        name = "completed_units",
        joinColumns = @JoinColumn(name = "course_status_id"),
        inverseJoinColumns = @JoinColumn(name = "learning_unit_id")
    )
    private List<LearningUnit> completedUnits;

    @ManyToOne
    @JoinColumn(name = "current_unit_id", nullable = true)
    private LearningUnit currentUnit;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;

    private String grade;

    private double percentage;

    private int percentCompleted;
}
