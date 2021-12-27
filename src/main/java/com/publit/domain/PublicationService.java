package com.publit.domain;

import com.publit.data.dao.repos.PublicationRepo;
import com.publit.data.dao.repos.UserRepo;
import com.publit.data.model.Publication;
import com.publit.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepo publicationRepo;
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public int addPublication(String name, String token) {
        User user = userRepo.findByToken(token);
        Publication publication = new Publication(name, user);
        publicationRepo.save(publication);
        user.getPublications().add(publication);
        return publicationRepo.findByPubName(name).getId();
    }
}
