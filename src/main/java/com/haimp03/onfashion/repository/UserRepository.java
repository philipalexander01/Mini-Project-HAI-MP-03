package com.haimp03.onfashion.repository;

import com.haimp03.onfashion.dto.UserData;
import com.haimp03.onfashion.entity.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Modifying
    @Query("update User u set u.fullname = ?1, u.username = ?2 where u.user_id = ?3")
    public void updateUserWithoutPassword(String fullname, String username, Long id);
}
