package com.frenzo.course.module.toc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TopicRepo extends JpaRepository<Topic, Integer> {
}
