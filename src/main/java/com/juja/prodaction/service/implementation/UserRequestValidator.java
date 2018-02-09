package com.juja.prodaction.service.implementation;

import com.juja.prodaction.dao.UserRepository;
import com.juja.prodaction.domain.request.UserCreateRequest;
import com.juja.prodaction.exception.BaseProductionException;
import com.juja.prodaction.exception.custom.LenthCustomException;
import com.juja.prodaction.exception.custom.NameAlreadyExistException;
import com.juja.prodaction.exception.custom.NullCustomException;
import com.juja.prodaction.exception.model.NullProductionError;
import com.juja.prodaction.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * @author Dmitriy Lyashenko
 */
@Service
public class UserRequestValidator implements Validator<UserCreateRequest> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(UserCreateRequest request) {
        Class clazz = request.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                checkField(field, request);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkField(Field field, UserCreateRequest request) throws IllegalAccessException {
        if (field.get(request) == null){
            throw new NullCustomException(
                    getCommonProductionError(String.format("Ops! [%s] can't be null!", field.getName())));
        }

        String value = (String) field.get(request);

        if (field.getName().equalsIgnoreCase("name")){
            if (value.length() > 32) {
                throw new LenthCustomException(
                        getCommonProductionError(
                                String.format("Ops! length of -> [%s] -> [{%s}]can't be more then 32!", field.getName(), value)));
            }
            if (userRepository.findByName(value) != null){
                throw new NameAlreadyExistException(
                        getCommonProductionError(
                                String.format("Ops! name -> [%s] already exist!", value)));
            }
        }
    }

    private NullProductionError getCommonProductionError(String format) {
        return new NullProductionError(
                format,
                BaseProductionException.DECLINED_STATUS,
                "Change your request");
    }
}
