package com.example.lab4.Model;

public class UserName extends User {
    public String Address;
    public String getAddress() {
        return Address;
    }
    public void setAddress(){
        this.Address = Address;
    }
    public void method() {
        System.out.println("Enter password" + getPassword());
        System.out.println("Check accuracy" + getId());
        System.out.println("Enter Address" + getAddress());
    }
}
