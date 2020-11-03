package com.ydv.pim.attribute;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Attribute  {

    private String name;
    private String datatype;
    private String _id;
    private String description;
    @JsonProperty
    private boolean isActive;
    private Number attributeId;
    private String createdAt;
    private String updatedAt;
    private String code;
    private String message;
    private String uom;


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


    public Number getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Number attributeId) {
        this.attributeId = attributeId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
