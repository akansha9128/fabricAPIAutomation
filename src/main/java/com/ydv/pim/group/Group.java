package com.ydv.pim.group;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {
    private String name;
    @JsonProperty
    private boolean isInternal;
    private String kind;
    private String[] channel;
    @JsonProperty
    private boolean isActive;
    @JsonProperty
    private boolean isSoftDeleted;
    private String _id;
    private Number groupId;
    private String[] images;
    private String[] videos;
    private String createdAt;
    private String updatedAt;
    private String parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsInternal() {
        return isInternal;
    }

    public void setInternal(boolean isinternal) {
       this.isInternal = isinternal;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean isactive) {
        this.isActive = isactive;
    }



    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String[] getChannel() {
        return channel;
    }

    public void setChannel(String[] channel) {
        this.channel = channel;
    }


    public boolean getisSoftDeleted() {
        return isSoftDeleted;
    }

    public void setSoftDeleted(boolean softDeleted) {
       this.isSoftDeleted = softDeleted;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Number getGroupId() {
        return groupId;
    }

    public void setGroupId(Number groupId) {
        this.groupId = groupId;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}