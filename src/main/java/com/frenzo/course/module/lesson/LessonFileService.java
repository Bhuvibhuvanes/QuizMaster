package com.frenzo.course.module.lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class LessonFileService {
    @Autowired
    LessonFileRepo lessonFileRepo;

    public List<LessonFile> getLessonFiles() {
        List<LessonFile> lessonFiles = lessonFileRepo.findAll();
        if (lessonFiles.size() > 0) {
            return lessonFiles;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public LessonFile addLessonFile(LessonFile lessonFile) {
        return lessonFileRepo.save(lessonFile);
    }

    public void deleteLessonFile(int id) {
        lessonFileRepo.deleteById(id);
    }

    public LessonFile getLessonFileById(int id) {
        Optional<LessonFile> lessonFile = lessonFileRepo.findById(id);
        if (lessonFile.isPresent()) {
            return lessonFile.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public LessonFile updateLessonFile(int id, LessonFile updatedLessonFile) {
        return lessonFileRepo.findById(id).map(existingLessonFile -> {
            updatedLessonFile.setFilePath(existingLessonFile.getFilePath());
            return lessonFileRepo.save(updatedLessonFile);
        }).orElseThrow(() -> new RuntimeException("Lesson File with ID " + id + " not found"));
    }
    
}
