package com.publit.data.dao.repos;

import com.publit.data.model.Issue;
import org.springframework.data.repository.CrudRepository;

public interface IssueRepo extends CrudRepository<Issue, Integer> {
    Issue findByIssueName(String issueName);

    Issue findById(int id);
}
