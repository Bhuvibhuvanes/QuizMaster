package com.frenzo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "question_set")
public class QuestionSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float marks;

    private int numQuestions;

//    @ManyToMany
//    @JoinTable(
//        name = "question_set_questions",
//        joinColumns = @JoinColumn(name = "question_set_id"),
//        inverseJoinColumns = @JoinColumn(name = "question_id")
//    )
//    private Set<Question> questions = new HashSet<>();

}
