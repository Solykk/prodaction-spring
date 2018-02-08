package com.juja.prodaction.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juja.prodaction.util.DateConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Dmitriy Lyashenko
 */
@Entity
@Table(name = "additional_information", schema = "my_schema")
public class AdditionalInformation implements Serializable {

    @Id
    @GenericGenerator(
            name = "my_schema.additional_information_ai_id_seq",
            strategy = "org.hibernate.id.ForeignGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "property", value = "my_schema.statuses_st_id_seq"),
            }
    )
    @GeneratedValue(generator = "my_schema.additional_information_ai_id_seq")
    @Column(name = "ai_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "ai_address", nullable = false)
    private String address;

    @Column(name = "ai_age", nullable = false)
    private Integer age;
    /**
     * true -> man;
     * false -> woman
     */
    @Column(name = "ai_sex", nullable = false)
    private boolean sex;

    @JsonIgnore
    @Column(name = "ai_created_at", nullable = false)
    @Convert(converter = DateConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    @Column(name = "ai_updated_at", nullable = false)
    @Convert(converter = DateConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public AdditionalInformation() {
    }

    public AdditionalInformation(String address, Integer age, boolean sex) {
        this.address = address;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "AdditionalInformation{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", updatedAt=" + updatedAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
