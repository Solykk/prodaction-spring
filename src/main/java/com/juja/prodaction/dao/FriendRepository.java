package com.juja.prodaction.dao;

import com.juja.prodaction.domain.entity.Friend;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Dmitriy Lyashenko
 */
public interface FriendRepository extends CrudRepository<Friend, Long> {

    Friend findByName(String name);

}
