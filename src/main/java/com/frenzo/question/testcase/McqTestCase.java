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
public class McqTestCase extends TestCase {

    @Column(name = "options", columnDefinition = "TEXT")
    private String options;

    @Column(name = "correct", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean correct;

}
