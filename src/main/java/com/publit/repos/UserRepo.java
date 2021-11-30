package com.publit.repos;

import com.publit.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    List<User> findByUsername(String username);

    User findById(int id);
}
