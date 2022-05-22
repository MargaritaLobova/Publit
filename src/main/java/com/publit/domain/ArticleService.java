package com.publit.domain;

import com.publit.data.dao.repos.ArticleRepo;
import com.publit.data.dao.repos.IssueRepo;
import com.publit.data.dao.repos.UserRepo;
import com.publit.data.model.Article;
import com.publit.data.model.Issue;
import com.publit.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private IssueRepo issueRepo;

    @Transactional
    public int addArticle(String token, String articleName, String articleContent, int issueId) {
        User user = userRepo.findByToken(token);
        if (user == issueRepo.findById(issueId).getPublication().getUser()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            Issue issue = issueRepo.findById(issueId);
            Article article = new Article(articleName, articleContent, user, issue);
            articleRepo.save(article);
            issue.getArticleList().add(article);
            return 0;
        }
    }

    public int renameArticle() {
        //TODO implement
        return 0;
    }
}

