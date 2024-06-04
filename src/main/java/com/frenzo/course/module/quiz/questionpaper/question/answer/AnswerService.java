package com.frenzo.course.module.quiz.questionpaper.question.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    AnswerRepo answerRepo;

    public List<Answer> getAnswers() {
        List<Answer> answers = answerRepo.findAll();
        if (!answers.isEmpty()) {
            return answers;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public Answer addAnswer(Answer answer) {
        return answerRepo.save(answer);
    }

    public void deleteAnswer(int id) {
        answerRepo.deleteById(id);
    }

    public Answer getAnswerById(int id) {
        Optional<Answer> answer = answerRepo.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public Answer updateAnswer(int id, Answer updatedAnswer) {
        return answerRepo.findById(id).map(existingAnswer -> {
            updatedAnswer.setId(existingAnswer.getId());
            return answerRepo.save(updatedAnswer);
        }).orElseThrow(() -> new RuntimeException("Answer with ID " + id + " not found"));
    }
}