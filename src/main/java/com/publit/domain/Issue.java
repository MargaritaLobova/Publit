package com.publit.domain;

import javax.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public Issue(){
    }

}
