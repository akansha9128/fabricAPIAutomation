package com.ydv.pim.itemFamily;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ydv.BaseFields;

public class ItemFamily {
    private String name;
    private Attribute[] attributes;
    @JsonProperty
    private boolean isActive;
    private String parent;
    private Number itemFamilyId;
    private String createdAt;
    private String updatedAt;
    private String code;
    private String message;
    private String _id;


    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Number getItemFamilyId() {
        return itemFamilyId;
    }

    public void setItemFamilyId(Number itemFamilyId) {
        this.itemFamilyId = itemFamilyId;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

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
}
