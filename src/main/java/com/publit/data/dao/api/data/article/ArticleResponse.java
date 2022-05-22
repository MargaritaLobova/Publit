package com.publit.data.dao.api.data.article;

import lombok.Value;

@Value
public class ArticleResponse {
    int articleId;
    String status;
    String message;
}
