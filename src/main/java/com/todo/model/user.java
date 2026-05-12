package com.todo.model;

public class user {

    private int userId;
    private String name;
    private String email;
    private String password;

    // Default Constructor
    public user() 
    {

    }

    // Parameterized Constructor
    public user(int userId, String name,
                String email, String password) 
    {

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter for userId
    public int getUserId() 
    {
        return userId;
    }

    public void setUserId(int userId) 
    {
        this.userId = userId;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }


    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
}