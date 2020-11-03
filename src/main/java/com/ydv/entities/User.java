package com.ydv.entities;



public class User {

    // For tests using JsonObject
    public static final String LOGIN = "login";
    public static final String ACCOUNTID = "accountId";
    public static final String ID = "id";
    public static final String CODE = "code";

    private String login;

    private String accountId;
    private String _id;
    private String code;

    private String isActive;

    public String getisActive() {
        return isActive;
    }
    public String getLogin() {
        return login;
    }

    public String getAccountId() {
        return accountId;
    }

    public String get_id() {
        return _id;
    }

    public String getCode() {
        return code;
    }
}

