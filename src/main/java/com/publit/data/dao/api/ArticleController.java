package com.publit.data.dao.api;

import com.publit.data.dao.api.data.article.ArticleRequest;
import com.publit.data.dao.api.data.article.ArticleResponse;
import com.publit.data.dao.api.data.issue.IssueRequest;
import com.publit.data.dao.api.data.issue.IssueResponse;
import com.publit.domain.ArticleService;
import com.publit.domain.IssueService;
import com.publit.domain.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/api/v1/add-art")
    public ArticleResponse addArticle(@RequestHeader(name = "User") String token,
                                      @RequestBody ArticleRequest request) {
        return new ArticleResponse(articleService.addArticle(token, request.getArticleName(), request.getArticleContent(), request.getIssueId()),
                "OK", "Issue was added successfully");
    }

    //TODO delArticle
    //TODO renameArticle

}
