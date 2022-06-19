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
    @Column(unique = true)
    private User actor;
    @Column(unique = false, nullable = true)
    private String description;
    @Column(unique = false, nullable = false)
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
