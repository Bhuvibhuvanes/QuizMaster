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
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "id")
public class HookTestCase extends TestCase {

    @Column(name = "hook_code", columnDefinition = "TEXT")
    private String hookCode;

    @Column(name = "weight", columnDefinition = "FLOAT DEFAULT 1.0")
    private Float weight;

    @Column(name = "hidden", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean hidden;
}
