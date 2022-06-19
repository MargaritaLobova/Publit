package com.publit.domain;

import com.publit.data.dao.api.repos.ArticleRepo;
import com.publit.data.dao.api.repos.IssueRepo;
import com.publit.data.dao.api.repos.UserRepo;
import com.publit.data.model.Article;
import com.publit.data.model.Issue;
import com.publit.data.model.Publication;
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
            issue.getArticle().add(article);
            return article.getId();
        }
    }

    @Transactional
    public int renameArticle(int articleId, int issueId, String token, String newTitle) {
        Article article = articleRepo.findById(articleId);
        User user = userRepo.findByToken(token);
        if (user != article.getAuthor()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            Issue issue = issueRepo.findById(issueId);
            issue.getArticle().remove(article);
            article.setTitle(newTitle);
            articleRepo.save(article);
            issue.getArticle().add(article);
            return article.getId();
        }
    }

    @Transactional
    public int deleteArticle(int articleId, int issueId, String token, String newTitle) {
        Article article = articleRepo.findById(articleId);
        User user = userRepo.findByToken(token);
        if (user == issueRepo.findById(issueId).getPublication().getUser()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            Issue issue = issueRepo.findById(issueId);
            issue.getArticle().remove(article);
            articleRepo.deleteById(articleId);
            return 0;
        }
    }
}

