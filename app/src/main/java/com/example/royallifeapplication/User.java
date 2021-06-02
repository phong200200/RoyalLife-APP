package com.example.royallifeapplication;

public class User {

    public String fullname,email,username, pass;

    public User(){

    }
    public User(String fullname,String email,  String pass, String username){
        this.fullname = fullname;
        this.email = email;
        this.pass = pass;
        this.username = username;
    }
}
