package com.frenzo.assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssignmentUploadRepo extends JpaRepository<AssignmentUpload, Integer> {
}