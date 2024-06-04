package com.frenzo.course.module.lesson;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

@RestController
@RequestMapping("/lesson-files")
public class LessonFileController {
    @Autowired
    LessonFileService lessonFileService;

    @PostMapping
    public ResponseEntity<LessonFile> addLessonFile(@RequestBody LessonFile lessonFile) {
        LessonFile addedLessonFile = lessonFileService.addLessonFile(lessonFile);
        return new ResponseEntity<>(addedLessonFile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LessonFile>> getLessonFiles() {
        List<LessonFile> lessonFiles = lessonFileService.getLessonFiles();
        return new ResponseEntity<>(lessonFiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonFile> getLessonFileById(@PathVariable("id") int id) {
        LessonFile lessonFile = lessonFileService.getLessonFileById(id);
        return new ResponseEntity<>(lessonFile, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonFile> updateLessonFile(@PathVariable int id, @RequestBody LessonFile lessonFile) {
        LessonFile updatedLessonFile = lessonFileService.updateLessonFile(id, lessonFile);
        return new ResponseEntity<>(updatedLessonFile, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteLessonFile(@PathVariable int id) throws NotFoundException {
        lessonFileService.deleteLessonFile(id);
        return HttpStatus.OK;
    }
}