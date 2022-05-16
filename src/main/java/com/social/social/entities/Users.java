package com.social.social.entities;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "users")
public class Users {
    @Id
    private ObjectId id;
    private String name, last, email;
    private LocalDate date; //date of birth

    public Users() {
    }

    public Users(ObjectId id, String name, String last,String email, LocalDate date) {
        this.id = id;
        this.name = name;
        this.last = last;
        this.date = date;
        this.email = email;
    }

    public Users(String name, String last,String email, LocalDate date) {
        this.name = name;
        this.last = last;
        this.date = date;
        this.email = email;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getName().hashCode() * this.getLast().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + date +
                '}';
    }
}
