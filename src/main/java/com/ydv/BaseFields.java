package com.ydv;

public class BaseFields {

    protected String name;
    protected String _id;
    protected com.ydv.addresses[] addresses;
    protected String code;
    protected String message;
    protected String isActive;
    private String displayText;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public com.ydv.addresses[] getAddresses() {
        return addresses;
    }

    public void setAddresses(com.ydv.addresses[] addresses) {
        this.addresses = addresses;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
