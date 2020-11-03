package com.ydv.pim.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes {
    private String id;
    private String value;
    private String _id;
    @JsonProperty
    private boolean isDefault;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }


}
