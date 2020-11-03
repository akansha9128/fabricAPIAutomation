package com.ydv.xpm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageUpdate {

	private String _id;
	@JsonProperty
	private boolean isActive;
	@JsonProperty
	private boolean isArchived;
    private String name;
    private String pageUrl;
    private Number pageId;
    private String createdAt;
    private String updatedAt;
    private Number __v;







    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Number getPageId() {
        return pageId;
    }

    public void setPageId(Number pageId) {
        this.pageId = pageId;
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



}
