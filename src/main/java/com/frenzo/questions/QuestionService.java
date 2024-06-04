package com.frenzo.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public List<Question> getQuestions() {
        List<Question> questions = questionRepo.findAll();
        if (!questions.isEmpty()) {
            return questions;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    public void deleteQuestion(int id) {
        questionRepo.deleteById(id);
    }

    public Question getQuestionById(int id) {
        Optional<Question> question = questionRepo.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public Question updateQuestion(int id, Question updatedQuestion) {
        return questionRepo.findById(id).map(existingQuestion -> {
            updatedQuestion.setId(existingQuestion.getId());
            return questionRepo.save(updatedQuestion);
        }).orElseThrow(() -> new RuntimeException("Question with ID " + id + " not found"));
    }
}