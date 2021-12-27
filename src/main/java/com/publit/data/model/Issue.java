package com.publit.data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String issueName;
    private int issueNum;

    @ManyToOne
    private Publication publication;

    public Issue() {
    }

    public Issue(String issueName, Publication publication) {
        setIssueName(issueName);
        setPublication(publication);
        setIssueNum(numberCounter());
    }

    private int numberCounter() {
        return publication.getIssues().size() + 1;
    }
}
