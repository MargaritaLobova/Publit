package com.publit.data.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(unique = true, nullable = false)
    private String content;

    @ManyToOne
    private User author;
    @ManyToOne
    private Issue issue;


    public Article() {
    }

    public Article(String title, String content, User author, Issue issue) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.issue = issue;
    }
}
