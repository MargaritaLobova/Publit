package com.publit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private String pubName;
    public Publication() {}

    public Publication(String pubName) {
        setPubName(pubName);
    }
}
