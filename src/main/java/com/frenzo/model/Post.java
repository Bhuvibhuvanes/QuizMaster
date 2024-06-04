package com.frenzo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post extends ForumBase {
	
	    private String title;

//	    @ManyToOne
//	    @JoinColumn(name = "target_ct_id")
//	    private ContentType targetCt;

	    @Column(name = "target_id", nullable = true)
	    private Integer targetId;

	    @OneToMany
	    (mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Comment> comments;


}
