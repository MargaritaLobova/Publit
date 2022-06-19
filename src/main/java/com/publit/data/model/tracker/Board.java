package com.publit.data.model.tracker;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    public Board() {
    }

    public Board(String name) {
        this.name = name;
    }
}
