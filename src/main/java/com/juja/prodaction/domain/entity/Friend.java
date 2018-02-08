package com.juja.prodaction.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Dmitriy Lyashenko
 */
@Entity
@Table(name = "users", schema = "my_schema")
public class Friend implements Serializable {

    @Id
    @Column(name = "u_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "u_name", unique = true, nullable = false, updatable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        return name != null ? name.equals(friend.name) : friend.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                '}';
    }
}
