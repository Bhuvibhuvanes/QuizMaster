package com.frenzo.course.formbase;


import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post extends ForumBase {

    @Column(nullable = false, length = 200)
    
    private String title;
    
//    @ManyToOne
//    @JoinColumn(name = "target_ct_id", nullable = true)
//    private ContentType targetCt;

    @Column(name = "target_id", nullable = true)
    private Integer targetId;

    @Autowired
    @Transient
    private CommentRepository commentRepository;
}

