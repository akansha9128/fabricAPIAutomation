package com.ydv.CBL.auth;

public class User {
    private Extra extra;

    private Name name;

    private String email;

    public Extra getExtra ()
    {
        return extra;
    }

    public void setExtra (Extra extra)
    {
        this.extra = extra;
    }

    public Name getName ()
    {
        return name;
    }

    public void setName (Name name)
    {
        this.name = name;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }
}
