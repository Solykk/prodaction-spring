package com.juja.prodaction.dao;

import com.juja.prodaction.domain.entity.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Dmitriy Lyashenko
 */
public interface PostRepository extends CrudRepository<Post, String> {
}
