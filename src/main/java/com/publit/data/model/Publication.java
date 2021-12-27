package com.publit.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String pubName;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Issue> issues;

    public Publication() {
    }

    public Publication(String pubName, User user) {
        setPubName(pubName);
        setUser(user);
    }
}
