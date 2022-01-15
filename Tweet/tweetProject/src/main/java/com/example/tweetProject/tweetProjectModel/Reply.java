package com.example.tweetProject.tweetProjectModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="reply")
public class Reply {

    @Id
    @GeneratedValue
    private Long id;
    private Long tweetId;
    private Long userId;
    private Long replyId;
    private String text;
    private Date createdDate;
    private Date editedDate;

    public Reply(Long id, Long tweetId, Long userId, Long replyId, String text, Date createdDate, Date editedDate) {
        this.id = id;
        this.tweetId = tweetId;
        this.userId = userId;
        this.replyId = replyId;
        this.text = text;
        this.createdDate = createdDate;
        this.editedDate = editedDate;
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

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", tweetId=" + tweetId +
                ", userId=" + userId +
                ", replyId=" + replyId +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", editedDate=" + editedDate +
                '}';
    }
}
