package com.frenzo.course.module.quizs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    public List<Quiz> getQuizzes() {
        List<Quiz> quizzes = quizRepo.findAll();
        if (!quizzes.isEmpty()) {
            return quizzes;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public Quiz addQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    public void deleteQuiz(int id) {
        quizRepo.deleteById(id);
    }

    public Quiz getQuizById(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        if (quiz.isPresent()) {
            return quiz.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public Quiz updateQuiz(int id, Quiz updatedQuiz) {
        return quizRepo.findById(id).map(existingQuiz -> {
            updatedQuiz.setId(existingQuiz.getId());
            return quizRepo.save(updatedQuiz);
        }).orElseThrow(() -> new RuntimeException("Quiz with ID " + id + " not found"));
    }
}