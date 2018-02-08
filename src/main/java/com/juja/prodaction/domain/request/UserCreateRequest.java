package com.juja.prodaction.domain.request;

import com.juja.prodaction.domain.entity.AdditionalInformation;
import com.juja.prodaction.domain.entity.User;
import com.juja.prodaction.util.ProductionUtil;

import java.util.Collections;

/**
 * @author Dmitriy Lyashenko
 */
public class UserCreateRequest {

    private String name;
    private String email;
    private String address;
    private Integer age;
    private boolean sex;

    public User convert() {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .additionalInformation(new AdditionalInformation(this.address, this.age, this.sex))
                .areas(Collections.singleton(ProductionUtil.getAreaByKey("def")))
                .status(ProductionUtil.getStatusByKey("def"))
                .build();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserCreateRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
