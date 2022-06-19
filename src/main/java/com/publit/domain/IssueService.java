package com.publit.domain;

import com.publit.data.dao.api.repos.IssueRepo;
import com.publit.data.dao.api.repos.PublicationRepo;
import com.publit.data.dao.api.repos.UserRepo;
import com.publit.data.model.Issue;
import com.publit.data.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IssueService {
    @Autowired
    private IssueRepo issueRepo;
    @Autowired
    private PublicationRepo publicationRepo;
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public int addIssue(String token, String issueName, int publicationId) {
        if (userRepo.findByToken(token) != publicationRepo.findById(publicationId).getUser()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            Publication publication = publicationRepo.findById(publicationId);
            Issue issue = new Issue(issueName, publication);
            issueRepo.save(issue);
            publication.getIssues().add(issue);
            return issue.getId();
        }
        //TODO: rename issue;
        //TODO: delete issue;
    }
}
