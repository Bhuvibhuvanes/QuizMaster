package com.frenzo.course.module.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LessonFileRepo extends JpaRepository<LessonFile, Integer>{

}
