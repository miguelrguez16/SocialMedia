package com.social.social.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "posts")
public class Posts {

    @Id
    private ObjectId id;

    private String title, text;

    private ObjectId userId;

    private LocalDate datePosted;


    public Posts() { }

    public Posts(ObjectId id, String title, String text, ObjectId userId, LocalDate datePosted) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.datePosted = datePosted;
    }

    public Posts(String title, String text, ObjectId userId, LocalDate datePosted) {
        this.title = title;
        this.text = text;
        this.userId = userId;
        this.datePosted = datePosted;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + this.getId() +
                ", title='" + this.getTitle() + '\'' +
                ", text='" + this.getText() + '\'' +
                ", userId=" + this.getUserId() +
                ", datePosted=" + this.getDatePosted() +
                '}';
    }
}
