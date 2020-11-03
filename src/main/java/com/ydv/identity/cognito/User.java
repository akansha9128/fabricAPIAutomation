package com.ydv.identity.cognito;

public class User {

    private String user;
    private String registrationSite;
    private String email;
    private String username;
    private String password;
    private Provider provider[];
    private boolean isActive;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRegistrationSite() {
        return registrationSite;
    }

    public void setRegistrationSite(String registrationSite) {
        this.registrationSite = registrationSite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Provider[] getProvider() {
        return provider;
    }

    public void setProvider(Provider[] provider) {
        this.provider = provider;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
