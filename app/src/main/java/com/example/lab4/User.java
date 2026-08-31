package com.example.lab4;

public class User {
    public String password,id;
    public int data;
    public String UserName;

    void method(){
    }
    public String getPassword (){
        return password;
    }
    public String getId (){
        return id;
    }
    public void setUserName(String userName){
        this.UserName = userName;
    }
    public String getUserName(){
        return UserName;
    }
    public  void setPassword (){
        this.password = password;
    }
    public  void setId (){
        this.id = id;
    }
    public void login() {
        System.out.println("Login");
    }

    public void logout() {
        System.out.println("Logout");
    }

    public void createNote() {
        System.out.println("Create Note");
    }

    public void deleteNote() {
        System.out.println("Delete Note");
    }


}

