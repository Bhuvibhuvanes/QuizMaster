package com.frenzo.question.testcase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class HookTestCase extends TestCase {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Lob
    @Column(nullable = false)
    private String hookCode = "def check_answer(user_answer):\n" +
            "    ''' Evaluates user answer to return -\n" +
            "    success - Boolean, indicating if code was executed correctly\n" +
            "    mark_fraction - Float, indicating fraction of the\n" +
            "                   weight to a test case\n" +
            "    error - String, error message if success is false\n" +
            "\n" +
            "    In case of assignment upload there will be no user answer '''\n" +
            "\n" +
            "    success = False\n" +
            "    err = \"Incorrect Answer\" # Please make this more specific\n" +
            "    mark_fraction = 0.0\n" +
            "\n" +
            "    # write your code here\n" +
            "\n" +
            "    return success, err, mark_fraction";

    @Column(nullable = false)
    private float weight = 1.0f;

    @Column(nullable = false)
    private boolean hidden = false;

}
