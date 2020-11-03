package com.ydv.pim.itemFamily;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attribute {
    private String _id;
    private String id;
    private String name;
    private String datatype;
    private String value;
    private int order;
    @JsonProperty
    private boolean isRequired;
    @JsonProperty
    private boolean isActive;
    @JsonProperty
    private boolean isEditable;
    @JsonProperty
    private boolean isAttribute;
    @JsonProperty
    private boolean display;
    private String attributeGroupId;
    private boolean isMulitple;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }


    public boolean getIsEditable() {
        return isActive;
    }

    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }


    public boolean getIsAttribute() {
        return isAttribute;
    }

    public void setAttribute(boolean isAttribute) {
        this.isAttribute = isAttribute;
    }

    public boolean getIsRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }


    public boolean getdisplay() {
        return display;
    }

    public void setdisplay(boolean display) {
        this.display = display;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrder(int order){
        this.order = order;
    }
    public int getOrder(){
        return this.order;
    }
    public void setAttributeGroupId(String attributeGroupId){
        this.attributeGroupId = attributeGroupId;
    }
    public String getAttributeGroupId(){
        return this.attributeGroupId;
    }
    public void setIsMulitple(boolean isMulitple){
        this.isMulitple = isMulitple;
    }
    public boolean getIsMulitple(){
        return this.isMulitple;
    }
}
