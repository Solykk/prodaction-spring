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
@Table(name = "areas", schema = "my_schema")
public class Area implements Serializable {

    @Id
    @GenericGenerator(
            name = "my_schema.areas_ar_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_schema.areas_ar_id_seq")
    @Column(name = "ar_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "ar_code", nullable = false, unique = true)
    private String code;

    @Column(name = "ar_description", nullable = false)
    private String description;

    @Column(name = "ar_count", nullable = false)
    private Integer count;

    @JsonIgnore
    @Column(name = "ar_created_at", nullable = false)
    @Convert(converter = DateConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    @Column(name = "ar_updated_at", nullable = false)
    @Convert(converter = DateConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Area area = (Area) o;

        return code != null ? code.equals(area.code) : area.code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", updatedAt=" + updatedAt.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
