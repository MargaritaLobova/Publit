package com.publit.data.dao.api.repos;

import com.publit.data.model.tracker.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Task, Integer> {
    Task findById(int id);
}
