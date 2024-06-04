package com.frenzo.course.module.lesson;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frenzo.Exception.NotFoundException;

@RestController
@RequestMapping("/lessons")
public class LessonController {
	@Autowired
	LessonService lessonService;

	@PostMapping
	public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson) {
		Lesson less = lessonService.addLesson(lesson);
		return new ResponseEntity<Lesson>(less, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Lesson>> getLessons() {
		List<Lesson> lessons = lessonService.getLessons();
		return new ResponseEntity<List<Lesson>>(lessons, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Lesson> getLessonById(@PathVariable("id") int id) {
		Lesson lesson = lessonService.getLessonById(id);
		return new ResponseEntity<Lesson>(lesson, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Lesson> updateLesson(@PathVariable int id, @RequestBody Lesson lesson) {
		Lesson updatedLesson = lessonService.updateLesson(id, lesson);
		return new ResponseEntity<Lesson>(updatedLesson, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteLesson(@PathVariable int id) throws NotFoundException {
		lessonService.deleteLesson(id);
		return HttpStatus.OK;
	}

}
