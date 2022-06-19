package com.publit.data.dao.api.repos;

import com.publit.data.model.Publication;
import org.springframework.data.repository.CrudRepository;

public interface PublicationRepo extends CrudRepository<Publication, Integer> {
    Publication findByPubName(String pubName);

    Publication findById(int id);
}
