package com.juja.prodaction.service.implementation;

import com.juja.prodaction.dao.UserRepository;
import com.juja.prodaction.domain.request.UserCreateRequest;
import com.juja.prodaction.exception.BaseProductionException;
import com.juja.prodaction.exception.custom.NullCustomException;
import com.juja.prodaction.exception.model.NullProductionError;
import com.juja.prodaction.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dmitriy Lyashenko
 */
@Service
public class UserRequestValidator implements Validator<UserCreateRequest> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(UserCreateRequest request) {
        checkFieldOnNull(request.getName());
    }

    private void checkFieldOnNull(String field){
        if (field == null){
            throw new NullCustomException(
                    new NullProductionError(
                            "Ops! Name can't be null!",
                            BaseProductionException.DECLINED_STATUS,
                            "Change your request"));
        }
    }
}
