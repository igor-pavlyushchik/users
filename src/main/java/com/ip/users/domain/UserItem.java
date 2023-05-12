package com.ip.users.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * UserItem domain.
 */
@Entity
public class UserItem {
    @Id
    @GeneratedValue
    private Integer id;
    @Column (name = "user_name")
    private String userName;
    @Column(name = "amount-of-posts", columnDefinition = "int default 0")
    private Integer amountOfPosts = 0;

    public UserItem(final Integer id, final String userName, final Integer amountOfPosts) {
        this.id = id;
        this.userName = userName;
        this.amountOfPosts = amountOfPosts;
    }

    protected UserItem() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public Integer getAmountOfPosts() {
        return this.amountOfPosts;
    }

    public void setAmountOfPosts(final Integer amountOfPosts) {
        this.amountOfPosts = amountOfPosts;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final UserItem userItem = (UserItem)o;

        if (!Objects.equals(id, userItem.id)) return false;
        if (!Objects.equals(userName, userItem.userName)) return false;
        return Objects.equals(amountOfPosts, userItem.amountOfPosts);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (amountOfPosts != null ? amountOfPosts.hashCode() : 0);
        return result;
    }
}
