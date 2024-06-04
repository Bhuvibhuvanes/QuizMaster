package com.frenzo.assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentUploadService {
    @Autowired
    AssignmentUploadRepo assignmentUploadRepo;

    public List<AssignmentUpload> getAssignmentUploads() {
        List<AssignmentUpload> assignmentUploads = assignmentUploadRepo.findAll();
        if (assignmentUploads.size() > 0) {
            return assignmentUploads;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public AssignmentUpload addAssignmentUpload(AssignmentUpload assignmentUpload) {
        return assignmentUploadRepo.save(assignmentUpload);
    }

    public void deleteAssignmentUpload(int id) {
        assignmentUploadRepo.deleteById(id);
    }

    public AssignmentUpload getAssignmentUploadById(int id) {
        Optional<AssignmentUpload> assignmentUpload = assignmentUploadRepo.findById(id);
        if (assignmentUpload.isPresent()) {
            return assignmentUpload.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public AssignmentUpload updateAssignmentUpload(int id, AssignmentUpload updatedAssignmentUpload) {
        return assignmentUploadRepo.findById(id).map(existingAssignmentUpload -> {
            updatedAssignmentUpload.setId(existingAssignmentUpload.getId());
            return assignmentUploadRepo.save(updatedAssignmentUpload);
        }).orElseThrow(() -> new RuntimeException("Assignment Upload with ID " + id + " not found"));
    }
}