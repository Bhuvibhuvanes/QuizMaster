package com.frenzo.assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/assignment-uploads")
public class AssignmentUploadController {
    @Autowired
    AssignmentUploadService assignmentUploadService;

    @PostMapping
    public ResponseEntity<AssignmentUpload> addAssignmentUpload(@RequestBody AssignmentUpload assignmentUpload) {
        AssignmentUpload addedAssignmentUpload = assignmentUploadService.addAssignmentUpload(assignmentUpload);
        return new ResponseEntity<>(addedAssignmentUpload, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssignmentUpload>> getAssignmentUploads() {
        List<AssignmentUpload> assignmentUploads = assignmentUploadService.getAssignmentUploads();
        return new ResponseEntity<>(assignmentUploads, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentUpload> getAssignmentUploadById(@PathVariable("id") int id) {
        AssignmentUpload assignmentUpload = assignmentUploadService.getAssignmentUploadById(id);
        return new ResponseEntity<>(assignmentUpload, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignmentUpload> updateAssignmentUpload(@PathVariable int id, @RequestBody AssignmentUpload assignmentUpload) {
        AssignmentUpload updatedAssignmentUpload = assignmentUploadService.updateAssignmentUpload(id, assignmentUpload);
        return new ResponseEntity<>(updatedAssignmentUpload, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAssignmentUpload(@PathVariable int id) throws NotFoundException {
        assignmentUploadService.deleteAssignmentUpload(id);
        return HttpStatus.OK;
    }
}