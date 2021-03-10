package com.spring_sandbox.spring_sandbox.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Entity@Table(name = "DRAWING")@Getter
public class Drawing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DRAWING_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "IMAGE")
    private byte[] image;
    @Column(name = "LIKES")
    private int likes;
    @Column(name = "DISLIKES")
    private int dislikes;
    @Column(name = "DT_POSTED")
    private LocalDateTime dtPosted;
    @Column(name = "MY_COMMENT")
    private String myComment;

    @OneToMany(mappedBy = "drawing")
    List<Comment> comments;

    protected Drawing() {}
}
