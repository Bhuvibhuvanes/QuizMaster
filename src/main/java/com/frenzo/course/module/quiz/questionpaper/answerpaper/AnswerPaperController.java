package com.frenzo.course.module.quiz.questionpaper.answerpaper;

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
@RequestMapping("/answer-papers")
public class AnswerPaperController {
    @Autowired
    AnswerPaperService answerPaperService;

    @PostMapping
    public ResponseEntity<AnswerPaper> addAnswerPaper(@RequestBody AnswerPaper answerPaper) {
        AnswerPaper addedAnswerPaper = answerPaperService.addAnswerPaper(answerPaper);
        return new ResponseEntity<>(addedAnswerPaper, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnswerPaper>> getAnswerPapers() {
        List<AnswerPaper> answerPapers = answerPaperService.getAnswerPapers();
        return new ResponseEntity<>(answerPapers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerPaper> getAnswerPaperById(@PathVariable("id") int id) {
        AnswerPaper answerPaper = answerPaperService.getAnswerPaperById(id);
        return new ResponseEntity<>(answerPaper, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerPaper> updateAnswerPaper(@PathVariable int id, @RequestBody AnswerPaper answerPaper) {
        AnswerPaper updatedAnswerPaper = answerPaperService.updateAnswerPaper(id, answerPaper);
        return new ResponseEntity<>(updatedAnswerPaper, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAnswerPaper(@PathVariable int id) throws NotFoundException {
        answerPaperService.deleteAnswerPaper(id);
        return HttpStatus.OK;
    }
}
