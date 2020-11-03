package com.ydv.pim.item;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Item {
    private String title;
    private String itemFamily;
    private Number[] channel;
    private String[] group;
    private String sku;
    private String description;
    private String startDate;
    private String endDate;
    @JsonProperty
    private boolean isActive;
    private String[] imagesSetOnAttributes;
    @JsonProperty
    private boolean isDefault;
    @JsonProperty
    private boolean isSoftDeleted;
    private String _id;
    private String state;
    private Number itemId;
    private Image[] images;
    private String[] videos;
    private String[] files;
    private Attributes[] attributes;
    private String[] variants;
    private String createdAt;
    private String updatedAt;
    private Data[] data;
    private Error[] error;


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


    public String[] getVariants() {
        return variants;
    }

    public void setVariants(String[] variants) {
        this.variants = variants;
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


    public Attributes[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes[] attributes) {
        this.attributes = attributes;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public Error[] getError() {
        return error;
    }

    public void setError(Error[] error) {
        this.error = error;
    }
}
