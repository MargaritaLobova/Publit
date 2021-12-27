package com.publit.data.dao.api.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IssueRequest {
    private String name;
    private int publicationId;
}
