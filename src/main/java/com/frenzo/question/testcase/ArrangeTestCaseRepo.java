package com.frenzo.question.testcase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ArrangeTestCaseRepo extends JpaRepository<ArrangeTestCase, Integer> {
}