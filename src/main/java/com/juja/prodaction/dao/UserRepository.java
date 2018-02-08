package com.juja.prodaction.dao;

import com.juja.prodaction.domain.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dmitriy Lyashenko
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);

    @Transactional
    @Modifying
    @Query("update User as u set u.isEnabled = false where u.email =:email")
    void setSome(@Param("email") String email);

}
