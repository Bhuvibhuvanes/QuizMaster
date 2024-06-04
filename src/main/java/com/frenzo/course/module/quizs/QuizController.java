package com.frenzo.course.module.quizs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
	@Autowired
	QuizService quizService;

	@PostMapping
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
		Quiz addedQuiz = quizService.addQuiz(quiz);
		return new ResponseEntity<>(addedQuiz, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Quiz>> getQuizzes() {
		List<Quiz> quizzes = quizService.getQuizzes();
		return new ResponseEntity<>(quizzes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable("id") int id) {
		Quiz quiz = quizService.getQuizById(id);
		return new ResponseEntity<>(quiz, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Quiz> updateQuiz(@PathVariable int id, @RequestBody Quiz quiz) {
		Quiz updatedQuiz = quizService.updateQuiz(id, quiz);
		return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteQuiz(@PathVariable int id) throws NotFoundException {
		quizService.deleteQuiz(id);
		return HttpStatus.OK;
	}
}