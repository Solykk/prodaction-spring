package com.juja.prodaction.dao;

import com.juja.prodaction.domain.entity.Status;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Dmitriy Lyashenko
 */
public interface StatusRepository extends CrudRepository<Status, Long> {
}
