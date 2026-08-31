package com.example.lab4;

public class TextNote extends Note{
    public String content;
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    //method
    public String getSummary() {
        return "User Name : " + getUser().getUserName()
                + "\nTitle : " + getTitle()
                + "\nContent : " + content
                + "\nCreated Date : " + createdData;
    }

    public void setCreatedDate(String createdDate) {
        this.createdData = createdDate;
    }
}
