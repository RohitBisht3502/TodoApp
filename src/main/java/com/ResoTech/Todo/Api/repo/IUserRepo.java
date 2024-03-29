package com.ResoTech.Todo.Api.repo;

import com.ResoTech.Todo.Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String newEmail);
}
