package com.example.lab4;

public class Note {
    private String title;
    private String content;
    public String createdData;
    private User user;
    private  String summary;


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
    public void setSummary(String summary){
        this.summary = summary;
    }
    public void setCreatedData(String createdData) {
        this.createdData = createdData;
    }
}
