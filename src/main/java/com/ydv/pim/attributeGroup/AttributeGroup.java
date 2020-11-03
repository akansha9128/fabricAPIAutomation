package com.ydv.pim.attributeGroup;

public class AttributeGroup {
    private boolean isActive;

    private String _id;

    private String name;

    private Attributes[] attributes;

    private int attributeGroupId;

    private String createdAt;

    private String updatedAt;

    private String code;

    private String message;

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    public boolean getIsActive(){
        return this.isActive;
    }
    public void set_id(String _id){
        this._id = _id;
    }
    public String get_id(){
        return this._id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAttributes(Attributes[] attributes){
        this.attributes = attributes;
    }
    public Attributes[] getAttributes(){
        return this.attributes;
    }
    public void setAttributeGroupId(int attributeGroupId){
        this.attributeGroupId = attributeGroupId;
    }
    public int getAttributeGroupId(){
        return this.attributeGroupId;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
    public String getUpdatedAt(){
        return this.updatedAt;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }


}
