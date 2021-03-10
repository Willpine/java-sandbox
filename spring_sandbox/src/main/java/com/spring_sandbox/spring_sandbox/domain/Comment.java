package com.spring_sandbox.spring_sandbox.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spring_sandbox.spring_sandbox.dto.command.CreateCommentCommand;

import lombok.Getter;

@Entity@Table(name = "COMMENT")@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "DT_PUBLISHED")
    private LocalDateTime dtPublished;
    @Column(name = "DT_EDITED")
    private LocalDateTime dtEdited;
    @Column(name = "LIKES")
    private int likes;
    @Column(name = "DISLIKES")
    private int dislikes;

    //@ManyToOne
    //private User user;

    @ManyToOne
    @JoinColumn(name = "DRAWING_ID", nullable = false)
    private Drawing drawing;

    public static Comment addComment(CreateCommentCommand command) {
        //command.validate();
        return new Comment(command);
    }

    private Comment(CreateCommentCommand command){
        this.text = command.getText();
        this.dtPublished = LocalDateTime.now();
    }

    protected Comment() { }
}
