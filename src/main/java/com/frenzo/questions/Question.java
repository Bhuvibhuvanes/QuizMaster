package com.frenzo.questions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String summary;

	@Lob
	private String description;

	private float points = 1.0f;

	private String language;

	private String topic;

	private String type;

	private boolean active = true;

	@ElementCollection
	@CollectionTable(name = "question_tags", joinColumns = @JoinColumn(name = "question_id"))
	@Column(name = "tag")
	private Set<String> tags = new HashSet<>();

	@Lob
	private String snippet;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

	private boolean partialGrading = false;

	private boolean gradeAssignmentUpload = false;

	private int minTime = 0;

	@Lob
	private String solution;

//    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<TestCase> testCases = new ArrayList<>();
}