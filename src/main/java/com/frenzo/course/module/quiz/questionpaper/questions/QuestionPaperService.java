package com.frenzo.course.module.quiz.questionpaper.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionPaperService {
    @Autowired
    QuestionPaperRepo questionPaperRepo;

    public List<QuestionPaper> getQuestionPapers() {
        List<QuestionPaper> questionPapers = questionPaperRepo.findAll();
        if (!questionPapers.isEmpty()) {
            return questionPapers;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public QuestionPaper addQuestionPaper(QuestionPaper questionPaper) {
        return questionPaperRepo.save(questionPaper);
    }

    public void deleteQuestionPaper(int id) {
        questionPaperRepo.deleteById(id);
    }

    public QuestionPaper getQuestionPaperById(int id) {
        Optional<QuestionPaper> questionPaper = questionPaperRepo.findById(id);
        if (questionPaper.isPresent()) {
            return questionPaper.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public QuestionPaper updateQuestionPaper(int id, QuestionPaper updatedQuestionPaper) {
        return questionPaperRepo.findById(id).map(existingQuestionPaper -> {
            updatedQuestionPaper.setId(existingQuestionPaper.getId());
            return questionPaperRepo.save(updatedQuestionPaper);
        }).orElseThrow(() -> new RuntimeException("Question Paper with ID " + id + " not found"));
    }
}