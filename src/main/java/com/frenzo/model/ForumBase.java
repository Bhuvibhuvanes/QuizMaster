package com.frenzo.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ForumBase {

    @Id
    @GeneratedValue
    (strategy = GenerationType
    .AUTO)
    private Long id;

    @Column(name = "uid", unique = true, nullable = false)
    private UUID uid;

//    @ManyToOne
//    @JoinColumn(name = "creator_id", nullable = false)
//    private User creator;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    private String image;

    private boolean active;

    private boolean anonymous;

}
