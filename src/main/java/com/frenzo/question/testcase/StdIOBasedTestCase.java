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
public class StdIOBasedTestCase extends TestCase {

    @Column(name = "expected_input", columnDefinition = "TEXT")
    private String expectedInput;

    @Column(name = "expected_output", nullable = false, columnDefinition = "TEXT")
    private String expectedOutput;

    @Column(name = "weight", columnDefinition = "INT DEFAULT 1")
    private Integer weight;

    @Column(name = "hidden", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean hidden;
}
