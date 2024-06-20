package com.frenzo.question.testcase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//@PrimaryKeyJoinColumn(name = "id")
//@Table(name="floattestcase")
public class FloatTestCase extends TestCase {

    @Column(name = "correct", columnDefinition = "FLOAT")
    private Float correct;

    @Column(name = "error_margin", columnDefinition = "FLOAT DEFAULT 0.0")
    private Float errorMargin;
}
