package com.publit.domain;

import com.publit.data.dao.api.repos.BoardRepo;
import com.publit.data.dao.api.repos.IssueRepo;
import com.publit.data.dao.api.repos.UserRepo;
import com.publit.data.model.User;
import com.publit.data.model.tracker.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private IssueRepo issueRepo;

    @Autowired
    private BoardRepo boardRepo;

    @Transactional
    public int addBoard(String token, int boardId, int issueId) {
        User user = userRepo.findByToken(token);
        if (user == issueRepo.findById(issueId).getPublication().getUser()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            Board board = boardRepo.findById(boardId);
            boardRepo.save(board);
            return board.getId();
        }
    }
    //TODO:rename board;
    //TODO:delete board;
}
