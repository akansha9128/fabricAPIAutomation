package com.ydv.offer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ydv.pim.item.Image;

public class Items {

    private String _id;
    private Number[] channel;
    private String startDate;
    private String endDate;
    private Groups[] group;
    private String[] imagesSetOnAttributes;
    @JsonProperty
    private boolean isActive;
    @JsonProperty
    private boolean isSoftDeleted;
    @JsonProperty
    private boolean isDefault;
    private Attribute[] attributes;

    private String parent;
    private String itemFamily;
    private String title;
    private String description;
    private Variant[] variants;
    private String state;
    private Number  itemId;
    private String[] images;
    private String[] videos;
    private String[] files;
    private String updatedAt;
    private String  createdAt;
    private String  __v;
    private String sku;
    private Groups[] groups;
    private String[] price;



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

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getItemFamily() {
        return itemFamily;
    }

    public void setItemFamily(String itemFamily) {
        this.itemFamily = itemFamily;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }


    public String[] getPrice() {
        return price;
    }

    public void setPrice(String[] price) {
        this.price = price;
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


    public Groups[] getGroup() {
        return group;
    }

    public void setGroup(Groups[] group) {
        this.group = group;
    }


    public Groups[] getGroups() {
        return groups;
    }

    public void setGroups(Groups[] groups) {
        this.groups = groups;
    }
}
