package com.example.lab4.Model;

import java.util.Date;

public class Note {
    private String title;
    private String content;
    public Date createdData;
    private User user;
    private  String Summary;


    //Method
    public String getTitle (){
        return title;
    }
    public  void setTitle (String title){
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setSummary(String summary){
        this.Summary = summary;
    }
    public void setCreatedData(Date createdData) {
        this.createdData = createdData;
    }
    public  Date getCreatedData(){return createdData;}
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public String getSummary() {
        return "User Name : " + user.getUserName()
                + "\nTitle : " + getTitle()
                + "\nContent : " + content
                + "\nCreated Date : " + createdData;
    }

    public String display() {
        return "Title: " + title + ", Content: " + content;
    }
}
