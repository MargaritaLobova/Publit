package com.publit.data.dao.api.repos;

import com.publit.data.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article, Integer> {
    Article findByTitle(String articleName);

    Article findById(int id);
}
