package com.ydv.pim.collection;

public class Collection {

    private String title;
    private Media[] media;
    private boolean isActive;

    private String[] items;

    private String startDate;

    private String endDate;

    private String[] channel;

    private String _id;

    private int collectionId;

    private String createdAt;

    private String updatedAt;
    private String code;

    private String message;

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

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setMedia(Media[] media){
        this.media = media;
    }
    public Media[] getMedia(){
        return this.media;
    }
    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    public boolean getIsActive(){
        return this.isActive;
    }

    public void setItems(String[] items){
        this.items = items;
    }
    public String[] getItems(){
        return this.items;
    }
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    public String getStartDate(){
        return this.startDate;
    }
    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
    public String getEndDate(){
        return this.endDate;
    }
    public void setChannel(String[] channel){
        this.channel = channel;
    }
    public String[] getChannel(){
        return this.channel;
    }
    public void set_id(String _id){
        this._id = _id;
    }
    public String get_id(){
        return this._id;
    }
    public void setCollectionId(int collectionId){
        this.collectionId = collectionId;
    }
    public int getCollectionId(){
        return this.collectionId;
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
}
