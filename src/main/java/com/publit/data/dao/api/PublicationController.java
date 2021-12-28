package com.publit.data.dao.api;

import com.publit.data.dao.api.data.pub.PublicationRenameRequest;
import com.publit.data.dao.api.data.pub.PublicationRequest;
import com.publit.data.dao.api.data.pub.PublicationResponse;
import com.publit.domain.PublicationService;
import com.publit.data.dao.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/api/v1/add-pub")
    public PublicationResponse addPublication(@RequestHeader(name = "User") String token,
                                              @RequestBody PublicationRequest request) {
        return new PublicationResponse(
                publicationService.addPublication(publicationRequestToPubName(request), token));
    }

    private String publicationRequestToPubName(PublicationRequest request) {
        return request.getName();
    }

    @PostMapping("/api/v1/rename-pub")
    public PublicationResponse renamePublication(@RequestHeader(name = "User") String token,
                                                 @RequestBody PublicationRenameRequest request) {
        return new PublicationResponse(
                publicationService.renamePublication(request.getNewName(), request.getId(), token));
    }
    //TODO del-pub
}
