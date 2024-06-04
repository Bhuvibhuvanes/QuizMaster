package com.frenzo.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
	@Autowired
	CourseRepo courseRepo;

	public List<Course> getCourses() {
		List<Course> courses = courseRepo.findAll();
		if (!courses.isEmpty()) {
			return courses;
		} else {
			throw new NotFoundException("No records found");
		}
	}

	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}

	public void deleteCourse(int id) {
		courseRepo.deleteById(id);
	}

	public Course getCourseById(int id) {
		Optional<Course> course = courseRepo.findById(id);
		if (course.isPresent()) {
			return course.get();
		} else {
			throw new NotFoundException("No records found");
		}
	}

	public Course updateCourse(int id, Course updatedCourse) {
		return courseRepo.findById(id).map(existingCourse -> {
			updatedCourse.setId(existingCourse.getId());
			return courseRepo.save(updatedCourse);
		}).orElseThrow(() -> new RuntimeException("Course with ID " + id + " not found"));
	}
}