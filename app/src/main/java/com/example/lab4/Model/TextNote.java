package com.example.lab4.Model;

import java.util.Date;

public class TextNote extends Note {
    public String content;
    public TextNote(String strOftitle, String strOfcontent, Date strOfdate) {
        super();
        setTitle(strOftitle);
        setContent(strOfcontent);
        setCreatedData(strOfdate);
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent(){
        return content;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdData = createdDate;
    }
    public String getSummary() {
        return "User Name : " + getUser().getUserName()
                + "\nTitle : " + getTitle()
                + "\nContent : " + content
                + "\nCreated Date : " + createdData;
    }

}
