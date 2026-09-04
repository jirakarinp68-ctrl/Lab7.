package com.example.lab4.Model;

public class ChackListNote extends Note {
    public String item;

    public void setItems() {
        this.item = item;
    }
    public String getItems() {
        return item;
    }

    public String getSummary() {
        System.out.println("Title : " + getTitle() + " Date : " + createdData + " Item : " + item);
        return getTitle() + createdData + item;
    }
}
