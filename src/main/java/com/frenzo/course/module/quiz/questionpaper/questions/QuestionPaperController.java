package com.frenzo.course.module.quiz.questionpaper.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/question-papers")//799b2588e92449e983401f533e9337e7 //id
//b28554b39f0b4a73aca92f8baa546e89  //secreate 
public class QuestionPaperController {
    @Autowired
    QuestionPaperService questionPaperService;

    @PostMapping
    public ResponseEntity<QuestionPaper> addQuestionPaper(@RequestBody QuestionPaper questionPaper) {
        QuestionPaper addedQuestionPaper = questionPaperService.addQuestionPaper(questionPaper);
        return new ResponseEntity<>(addedQuestionPaper, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionPaper>> getQuestionPapers() {
        List<QuestionPaper> questionPapers = questionPaperService.getQuestionPapers();
        return new ResponseEntity<>(questionPapers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionPaper> getQuestionPaperById(@PathVariable("id") int id) {
        QuestionPaper questionPaper = questionPaperService.getQuestionPaperById(id);
        return new ResponseEntity<>(questionPaper, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionPaper> updateQuestionPaper(@PathVariable int id, @RequestBody QuestionPaper questionPaper) {
        QuestionPaper updatedQuestionPaper = questionPaperService.updateQuestionPaper(id, questionPaper);
        return new ResponseEntity<>(updatedQuestionPaper, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteQuestionPaper(@PathVariable int id) throws NotFoundException {
        questionPaperService.deleteQuestionPaper(id);
        return HttpStatus.OK;
    }
}