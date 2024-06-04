package com.frenzo.course.module.lesson;

import com.frenzo.entity.UserInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(columnDefinition = "TEXT")
	private String htmlData;

	@ManyToOne
	@JoinColumn(name = "creator_id", nullable = false)
	private UserInfo creator;
	private boolean active = true;

	@Column(name = "video_file", length = 255)
	private String videoFile;

	@Column(name = "video_path", length = 255)
	private String videoPath;

	public enum LessonType {
		GOOGLE("google"), VIDEO("video");

		private final String type;

		LessonType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "lesson_type", length = 10)
	private LessonType lessonType;

	@Column(name = "google_slide_path", length = 255)
	private String googleSlidePath;

}
