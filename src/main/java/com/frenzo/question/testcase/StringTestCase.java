package com.frenzo.question.testcase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class StringTestCase extends TestCase {

    @Column(name = "correct", columnDefinition = "TEXT")
    private String correct;

    @Column(name = "string_check", length = 200)
    private String stringCheck;
}
