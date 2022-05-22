package com.publit.data.dao.api.data.pub;

import lombok.Value;

@Value
public class PublicationResponse {
    int publicationId;
    String status;
    String message;
}
