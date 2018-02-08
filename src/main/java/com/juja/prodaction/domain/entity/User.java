package com.juja.prodaction.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juja.prodaction.util.DateConverter;
import com.juja.prodaction.util.DateSerializer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dmitriy Lyashenko
 */
@Entity
@Table(name = "users", schema = "my_schema")
public class User implements Serializable {

    @Id
    @GenericGenerator(
            name = "my_schema.users_u_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "my_schema.users_u_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_schema.users_u_id_seq")
    @Column(name = "u_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "u_name", unique = true, nullable = false)
    private String name;

    @Column(name = "u_email", unique = true, nullable = false)
    private String email;

    @Column(name = "u_address", nullable = false)
    private String address;

    @Column(name = "u_age", nullable = false)
    private Integer age;

    /**
     * true -> man;
     * false -> woman
     */
    @Column(name = "u_sex", nullable = false)
    private boolean sex;

    @ManyToOne
    @JoinColumn(name = "u_status", referencedColumnName = "st_id")
    private Status status;

    @Column(name = "u_is_enabled", nullable = false)
    private boolean isEnabled = true;

    @ManyToMany
    @JoinTable(
            name = "user_areas", schema = "my_schema",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "area_id", referencedColumnName = "ar_id")}
    )
    private Set<Area> areas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_friends", schema = "my_schema",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_friend_id", referencedColumnName = "u_id")}
    )
    private Set<Friend> friends = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_user_id", referencedColumnName = "u_id")
    private List<Post> posts = new ArrayList<>();

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "u_created_at", nullable = false)
    @Convert(converter = DateConverter.class)
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "u_updated_at", nullable = false)
    @Convert(converter = DateConverter.class)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static UserBuilder builder(User user){
        return new UserBuilder(user);
    }

    public static class UserBuilder {

        private User instance;

        private UserBuilder(){instance = new User();}

        private UserBuilder(User user){instance = user;}

        public UserBuilder name(String name){
            instance.setName(name);
            return this;
        }

        public UserBuilder email(String email){
            instance.setEmail(email);
            return this;
        }

        public UserBuilder status(Status status){
            instance.setStatus(status);
            return this;
        }

        public UserBuilder friends(Set<Friend> friends){
            instance.setFriends(friends);
            return this;
        }

        public UserBuilder address(String address){
            instance.address = address;
            return this;
        }

        public UserBuilder age(Integer age){
            instance.age = age;
            return this;
        }

        public UserBuilder sex(boolean sex){
            instance.sex = sex;
            return this;
        }

        public UserBuilder isEnabled(boolean isEnabled){
            instance.setEnabled(isEnabled);
            return this;
        }

        public UserBuilder areas(Set<Area> areas){
            instance.setAreas(areas);
            return this;
        }

        public UserBuilder posts(List<Post> posts){
            instance.setPosts(posts);
            return this;
        }


        public UserBuilder updatedAt(LocalDateTime updatedAt){
            instance.setUpdatedAt(updatedAt);
            return this;
        }

        public User build() {
            return instance;
        }
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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

        User user = (User) o;

        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", status=" + status +
                ", isEnabled=" + isEnabled +
                ", areas=" + areas +
                ", friends=" + friends +
                ", posts=" + posts +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_DATE_TIME) +
                ", updatedAt=" + updatedAt.format(DateTimeFormatter.ISO_DATE_TIME) +
                '}';
    }
}
