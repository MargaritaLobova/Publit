package com.publit.data.dao.api.data.pub;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublicationRenameRequest {
    private int id;
    private String newName;
}
