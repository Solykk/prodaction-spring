package com.juja.prodaction.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juja.prodaction.util.DateConverter;
import com.juja.prodaction.util.DateSerializer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Dmitriy Lyashenko
 */
@Entity
@Table(name = "posts", schema = "my_schema")
public class Post implements Serializable {

    @Id
    @GenericGenerator(
            name = "my_schema.users_u_id_seq",
            strategy = "org.hibernate.id.UUIDHexGenerator"
    )
    @GeneratedValue(generator = "my_schema.users_u_id_seq")
    @Column(name = "p_uuid", nullable = false, unique = true, columnDefinition = "VARCHAR(32)")
    private String uuid;

    @Column(name = "p_message", nullable = false)
    private String message;

    @Column(name = "p_likes", nullable = false)
    private Integer likes = 0;

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "p_created_at", nullable = false)
    @Convert(converter = DateConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "p_updated_at", nullable = false)
    @Convert(converter = DateConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Post() {
    }

    public Post(String message) {
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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
        return "Post{" +
                "uuid='" + uuid + '\'' +
                ", message='" + message + '\'' +
                ", likes=" + likes +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
