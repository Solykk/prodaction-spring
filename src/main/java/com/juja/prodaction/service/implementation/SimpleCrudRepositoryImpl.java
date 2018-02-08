package com.juja.prodaction.service.implementation;

import com.juja.prodaction.dao.UserRepository;
import com.juja.prodaction.domain.entity.User;
import com.juja.prodaction.service.SimpleCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dmitriy Lyashenko
 */
@Service
public class SimpleCrudRepositoryImpl implements SimpleCrudRepository<User, Long> {

    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleCrudRepositoryImpl.class);

    private UserRepository userRepository;

    @Override
    public User create(User object) {
        return userRepository.save(object);
    }

    @Override
    public User read(Long aLong) {
        return userRepository.findOne(aLong);
    }

    @Override
    public Iterable<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(Long aLong) {
        userRepository.delete(aLong);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
