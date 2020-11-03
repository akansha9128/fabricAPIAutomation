package com.ydv.pim.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    private String title;
    private String itemFamily;
    private Number[] channel;
    private String[] group;
    private String sku;
    private String description;
    private String startDate;
    private String endDate;
    private String[] imagesSetOnAttributes;
    private String _id;
    @JsonProperty
    private boolean isDefault;
    @JsonProperty
    private boolean isActive;
    @JsonProperty
    private boolean isSoftDeleted;
    private Attributes[] attributes;
    private String parent;
    private Variant[] variants;
    private String state;
    private Number itemId;
    private Image[] images;
    private String[] videos;
    private String[] files;
    private String createdAt;
    private String updatedAt;


    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }


    public boolean getIsDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean getIsSoftDeleted() {
        return isSoftDeleted;
    }

    public void setSoftDeleted(boolean isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemFamily() {
        return itemFamily;
    }

    public void setItemFamily(String itemFamily) {
        this.itemFamily = itemFamily;
    }

    public Number[] getChannel() {
        return channel;
    }

    public void setChannel(Number[] channel) {
        this.channel = channel;
    }

    public String[] getGroup() {
        return group;
    }

    public void setGroup(String[] group) {
        this.group = group;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String[] getImagesSetOnAttributes() {
        return imagesSetOnAttributes;
    }

    public void setImagesSetOnAttributes(String[] imagesSetOnAttributes) {
        this.imagesSetOnAttributes = imagesSetOnAttributes;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Attributes[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes[] attributes) {
        this.attributes = attributes;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Variant[] getVariants() {
        return variants;
    }

    public void setVariants(Variant[] variants) {
        this.variants = variants;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Number getItemId() {
        return itemId;
    }

    public void setItemId(Number itemId) {
        this.itemId = itemId;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
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
}
