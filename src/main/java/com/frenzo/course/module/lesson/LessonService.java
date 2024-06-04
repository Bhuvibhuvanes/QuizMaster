package com.frenzo.course.module.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.course.module.lesson.Lesson;

@Service
public class LessonService {
	@Autowired
	LessonRepository lessrepositroy;

	
	public Lesson addLesson(Lesson lesson) {
//		Lesson less=
		return null;
	}
//
	public List<Lesson> getLessons() {
		return null;
	}

	public Lesson getLessonById(int id) {
		return null;
	}

	public Lesson updateLesson(int id, Lesson lesson) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteLesson(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
