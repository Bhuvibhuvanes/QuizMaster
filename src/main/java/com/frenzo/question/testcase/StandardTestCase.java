package com.frenzo.question.testcase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class StandardTestCase extends TestCase {

    @Column(name = "test_case", columnDefinition = "TEXT")
    private String testCase;

    @Column(name = "weight", columnDefinition = "FLOAT DEFAULT 1.0")
    private Float weight;

    @Column(name = "test_case_args", columnDefinition = "TEXT")
    private String testCaseArgs;

    @Column(name = "hidden", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean hidden;
}