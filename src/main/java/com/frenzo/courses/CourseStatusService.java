package com.frenzo.courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseStatusService {
    @Autowired
    CourseStatusRepo courseStatusRepo;

    public List<CourseStatus> getCourseStatuses() {
        List<CourseStatus> courseStatuses = courseStatusRepo.findAll();
        if (!courseStatuses.isEmpty()) {
            return courseStatuses;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public CourseStatus addCourseStatus(CourseStatus courseStatus) {
        return courseStatusRepo.save(courseStatus);
    }

    public void deleteCourseStatus(int id) {
        courseStatusRepo.deleteById(id);
    }

    public CourseStatus getCourseStatusById(int id) {
        Optional<CourseStatus> courseStatus = courseStatusRepo.findById(id);
        if (courseStatus.isPresent()) {
            return courseStatus.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public CourseStatus updateCourseStatus(int id, CourseStatus updatedCourseStatus) {
        return courseStatusRepo.findById(id).map(existingCourseStatus -> {
            updatedCourseStatus.setId(existingCourseStatus.getId());
            return courseStatusRepo.save(updatedCourseStatus);
        }).orElseThrow(() -> new RuntimeException("CourseStatus with ID " + id + " not found"));
    }
}