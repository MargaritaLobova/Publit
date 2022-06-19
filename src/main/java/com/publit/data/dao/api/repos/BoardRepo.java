package com.publit.data.dao.api.repos;

import com.publit.data.model.tracker.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepo extends CrudRepository<Board, Integer> {
    Board findById(int id);
}
