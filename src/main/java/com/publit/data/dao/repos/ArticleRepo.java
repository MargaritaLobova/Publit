package com.publit.data.dao.repos;

import com.publit.data.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article, Integer> {
    Article findByArticleName(String articleName);

    Article findById(int id);
}
