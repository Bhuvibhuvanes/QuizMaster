package com.frenzo.learningunitstatus;

import java.util.Date;

import com.frenzo.course.module.learning.unit.LearningUnit;
import com.frenzo.course.modules.LearningModule;
import com.frenzo.courses.Course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "learning_unit_status")
public class LearningUnitStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = false)
//	private User user;

	@ManyToOne
	@JoinColumn(name = "learning_unit_id", nullable = false)
	private LearningUnit learningUnit;

	@ManyToOne
	@JoinColumn(name = "learning_module_id", nullable = true)
	private LearningModule learningModule;

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

//	@Column(name = "completion_status", length = 50, nullable = false)
//	@Enumerated(EnumType.STRING)
//	private CompletionStatus completionStatus = CompletionStatus.NOT_STARTED;

	@Column(name = "date_started")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStarted;

	@Column(name = "date_completed")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCompleted;

	@Column(name = "score")
	private Float score;
}
