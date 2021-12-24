package com.publit.domain;

import javax.persistence.*;

@Entity
@Table(name = "magazine")
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public Magazine(){
    }
}
