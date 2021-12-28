package com.publit.data.dao.api.data.issue;

import lombok.Value;

@Value
public class IssueResponse {
    int issueId;
    String status;
    String message;
}
