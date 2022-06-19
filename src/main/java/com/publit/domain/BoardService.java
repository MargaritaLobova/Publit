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

    @Transactional
    public int deleteBoard(String token, int boardId, int issueId) {
        User user = userRepo.findByToken(token);
        if (user == issueRepo.findById(issueId).getPublication().getUser()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            Board board = boardRepo.findById(boardId);
            boardRepo.deleteById(boardId);
            return 0;
        }
    }

    //TODO: add board to issue;
    @Transactional
    public int renameBoard(String token, int boardId, int issueId, String newName) {
        User user = userRepo.findByToken(token);
        if (user == issueRepo.findById(issueId).getPublication().getUser()) {
            throw new IllegalArgumentException("Access denied");
        } else {
            Board board = boardRepo.findById(boardId);
            board.setName(newName);
            boardRepo.save(board);
            return board.getId();
        }
    }
}
