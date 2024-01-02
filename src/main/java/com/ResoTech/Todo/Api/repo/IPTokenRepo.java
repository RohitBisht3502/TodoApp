package com.ResoTech.Todo.Api.repo;

import com.ResoTech.Todo.Api.model.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPTokenRepo extends JpaRepository<UserAuthenticationToken,Integer> {
    UserAuthenticationToken findFirstByTokenValue(String tokenValue);
}
