package com.ydv.offer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Groups {

    private String _id;
    private Number[] channel;
    @JsonProperty
    private boolean isActive;
    @JsonProperty
    private boolean isInternal;
    @JsonProperty
    private boolean isSoftDeleted;
    private String name;
    private String kind;
    private Number groupid;
    private String[] images;
    private String createdAt;
    private String updatedAt;
    private String[] videos;
    private Number __v;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Number[] getChannel() {
        return channel;
    }

    public void setChannel(Number[] channel) {
        this.channel = channel;
    }

    public boolean getisSoftDeleted() {
        return isSoftDeleted;
    }

    public void setSoftDeleted(boolean softDeleted) {
        this.isSoftDeleted = softDeleted;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
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

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }

    public Number get__v() {
        return __v;
    }

    public void set__v(Number __v) {
        this.__v = __v;
    }

    public Number getGroupid() {
        return groupid;
    }

    public void setGroupid(Number groupid) {
        this.groupid = groupid;
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
}
