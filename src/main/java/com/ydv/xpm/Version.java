package com.ydv.xpm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Version {

    private String __id;
    @JsonProperty
    private boolean isArchived;
    private Number[] channel;
    private String status;
    private String endDate;
    private String pageId;
    private String name;
  
    private Number versionId;
    private String createdAt;

    private String updatedAt;
    private Number __v;
    private String globalComponentId;


    private String description;
    
    

    private Components[] components;
   







    public String get__id() {
        return __id;
    }

    public void set__id(String __id) {
        this.__id = __id;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public Number[] getChannel() {
        return channel;
    }

    public void setChannel(Number[] channel) {
        this.channel = channel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 

    public Number getVersionId() {
        return versionId;
    }

    public void setVersionId(Number versionId) {
        this.versionId = versionId;
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

    public Number get__v() {
        return __v;
    }

    public void set__v(Number __v) {
        this.__v = __v;
    }


    public String getGlobalComponentId() {
        return globalComponentId;
    }

    public void setGlobalComponentId(String globalComponentId) {
        this.globalComponentId = globalComponentId;
    }


   public Components[] getComponents() {
        return components;
    }

    public void setComponents(Components[] components) {
        this.components = components;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}