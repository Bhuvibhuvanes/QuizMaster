package com.frenzo.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/course-statuses")
public class CourseStatusController {
	@Autowired
	CourseStatusService courseStatusService;

	@PostMapping
	public ResponseEntity<CourseStatus> addCourseStatus(@RequestBody CourseStatus courseStatus) {
		CourseStatus addedCourseStatus = courseStatusService.addCourseStatus(courseStatus);
		return new ResponseEntity<>(addedCourseStatus, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<CourseStatus>> getCourseStatuses() {
		List<CourseStatus> courseStatuses = courseStatusService.getCourseStatuses();
		return new ResponseEntity<>(courseStatuses, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseStatus> getCourseStatusById(@PathVariable("id") int id) {
		CourseStatus courseStatus = courseStatusService.getCourseStatusById(id);
		return new ResponseEntity<>(courseStatus, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CourseStatus> updateCourseStatus(@PathVariable int id,
			@RequestBody CourseStatus courseStatus) {
		CourseStatus updatedCourseStatus = courseStatusService.updateCourseStatus(id, courseStatus);
		return new ResponseEntity<>(updatedCourseStatus, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteCourseStatus(@PathVariable int id) throws NotFoundException {
		courseStatusService.deleteCourseStatus(id);
		return HttpStatus.OK;
	}
}