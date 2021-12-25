package com.publit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private String issName;
    @Getter
    @Setter
    private String issueNum;

    public Issue() {}
    public Issue(String issName) {
        setIssName(issName);
    }

}
