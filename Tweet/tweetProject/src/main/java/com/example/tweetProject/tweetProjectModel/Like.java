package com.example.tweetProject.tweetProjectModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="likes")
public class Like {
@Id
@GeneratedValue
    private Long id;
    private Long tweetId;
    private Long userId;
    private String likedUser;
    private Date likedDate;

    public Like(Long id, Long tweetId, Long userId, String likedUser, Date likedDate) {
        this.id = id;
        this.tweetId = tweetId;
        this.userId = userId;
        this.likedUser = likedUser;
        this.likedDate = likedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLikedUser() {
        return likedUser;
    }

    public void setLikedUser(String likedUser) {
        this.likedUser = likedUser;
    }

    public Date getLikedDate() {
        return likedDate;
    }

    public void setLikedDate(Date likedDate) {
        this.likedDate = likedDate;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", tweetId=" + tweetId +
                ", userId=" + userId +
                ", likedUser='" + likedUser + '\'' +
                ", likedDate=" + likedDate +
                '}';
    }
}
