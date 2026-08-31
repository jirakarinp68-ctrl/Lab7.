package com.example.lab4;

public class ChackListNote extends Note{
    public String item;
    public ChackListNote() {

    }
    public String setItem() {
        this.item = item;
        return "";
    }

    public String getSummary() {
        System.out.println("Title : " + getTitle() + " Date : " + createdData + " Item : " + item);
        return getTitle() + createdData + item;
    }
}
