package com.publit.data.dao.api.data.article;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleRequest {
    String articleName;
    String articleContent;
    int issueId;
}
