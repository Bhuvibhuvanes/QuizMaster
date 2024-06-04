package com.frenzo.course.module.quiz.questionpaper.question.answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer) {
        Answer addedAnswer = answerService.addAnswer(answer);
        return new ResponseEntity<>(addedAnswer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAnswers() {
        List<Answer> answers = answerService.getAnswers();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") int id) {
        Answer answer = answerService.getAnswerById(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable int id, @RequestBody Answer answer) {
        Answer updatedAnswer = answerService.updateAnswer(id, answer);
        return new ResponseEntity<>(updatedAnswer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAnswer(@PathVariable int id) throws NotFoundException {
        answerService.deleteAnswer(id);
        return HttpStatus.OK;
    }
}