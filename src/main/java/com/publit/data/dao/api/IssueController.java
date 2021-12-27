package com.publit.data.dao.api;

import com.publit.data.dao.api.data.IssueRequest;
import com.publit.domain.IssueService;
import com.publit.domain.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class IssueController {
    @Autowired
    private PublicationService publicationService;
    @Autowired
    private IssueService issueService;

    @PostMapping("/api/v1/add-iss")
    public void addIssue(@RequestHeader(name = "User") String token,
                         @RequestBody IssueRequest request) {
        issueService.addIssue(token, request.getName(), request.getPublicationId());
    }

    //TODO delIssue
    //TODO renameIssue
}
