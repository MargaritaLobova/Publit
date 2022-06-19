package com.publit.data.model.tracker;

import com.publit.data.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    private User actor;

    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private KanbanColumn status;

    @ManyToOne
    private Board board;

    public Task() {
    }

    public Task(String name, User actor, String description, KanbanColumn status, Board board) {
        this.name = name;
        this.actor = actor;
        this.description = description;
        this.status = status;
        this.board = board;
    }
}
