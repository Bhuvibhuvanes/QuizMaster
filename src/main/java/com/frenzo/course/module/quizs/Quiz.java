package com.frenzo.course.module.quizs;

import java.time.LocalDateTime;

import com.frenzo.entity.UserInfo;

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
@Table(name = "quizzes")
public class Quiz {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    
	    private LocalDateTime startDateTime;

	    private LocalDateTime endDateTime;

	    private int duration;

	    private boolean active;

	    private String description;

	    private float passCriteria;

	    private int attemptsAllowed;

	    private float timeBetweenAttempts;

	    private boolean isTrial;

	    private String instructions;

	    private boolean viewAnswerpaper;

	    private boolean allowSkip;

	    private float weightage;

	    private boolean isExercise;

	    @ManyToOne
	    @JoinColumn(name = "creator_id")
	    private UserInfo creator;

}
