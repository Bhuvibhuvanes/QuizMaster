package com.frenzo.course.module.quiz.questionpaper.answerpaper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

@Service
public class AnswerPaperService {
    @Autowired
    AnswerPaperRepo answerPaperRepo;

    public List<AnswerPaper> getAnswerPapers() {
        List<AnswerPaper> answerPapers = answerPaperRepo.findAll();
        if (answerPapers.size() > 0) {
            return answerPapers;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public AnswerPaper addAnswerPaper(AnswerPaper answerPaper) {
        return answerPaperRepo.save(answerPaper);
    }

    public void deleteAnswerPaper(int id) {
        answerPaperRepo.deleteById(id);
    }

    public AnswerPaper getAnswerPaperById(int id) {
        Optional<AnswerPaper> answerPaper = answerPaperRepo.findById(id);
        if (answerPaper.isPresent()) {
            return answerPaper.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public AnswerPaper updateAnswerPaper(int id, AnswerPaper updatedAnswerPaper) {
        return answerPaperRepo.findById(id).map(existingAnswerPaper -> {
            updatedAnswerPaper.setId(existingAnswerPaper.getId());
            return answerPaperRepo.save(updatedAnswerPaper);
        }).orElseThrow(() -> new RuntimeException("Answer Paper with ID " + id + " not found"));
    }

}
