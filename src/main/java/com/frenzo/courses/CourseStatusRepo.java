package com.frenzo.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseStatusRepo extends JpaRepository<CourseStatus, Integer> {
}