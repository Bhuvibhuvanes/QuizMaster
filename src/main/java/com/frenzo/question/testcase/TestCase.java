package com.frenzo.question.testcase;


import com.frenzo.questions.Question;

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
@Getter
@Setter
public class TestCase {

    @Id
    @GeneratedValue
    (strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "type", length = 24)
    private String type;
}