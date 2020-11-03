package com.ydv.offer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ydv.pim.item.Attributes;
import com.ydv.pim.item.Image;
import com.ydv.pim.item.Item;
import com.ydv.pim.item.Variant;

public class Result {
    private String _id;
    private Number[] channel;
    private String startDate;
    private String endDate;
    private String[] group;
    private String[] imagesSetOnAttributes;
    @JsonProperty
    private boolean isDefault;
    @JsonProperty
    private boolean isSoftDeleted;
    @JsonProperty
    private boolean isActive;
    private String title;
    private String itemFamily;
    private String sku;
    private String description;
    private Number itemId;
    private String state;
    private Image[] images;
    private String[] videos;
    private String[] files;
    private Attributes[] attributes;
    private String[] variants;
    private String createdAt;
    private String updatedAt;
    private Number _v;
    private Items[] items;
    private PriceRange priceRange;
    private Number variantCount;
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

    public String[] getGroup() {
        return group;
    }

    public void setGroup(String[] group) {
        this.group = group;
    }

    public String[] getImagesSetOnAttributes() {
        return imagesSetOnAttributes;
    }

    public void setImagesSetOnAttributes(String[] imagesSetOnAttributes) {
        this.imagesSetOnAttributes = imagesSetOnAttributes;
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

    public Number getItemId() {
        return itemId;
    }

    public void setItemId(Number itemId) {
        this.itemId = itemId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public String[] getFiles() {
        return files;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public Attributes[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes[] attributes) {
        this.attributes = attributes;
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

    public Number get_v() {
        return _v;
    }

    public void set_v(Number _v) {
        this._v = _v;
    }


    public Number getVariantCount() {
        return variantCount;
    }

    public void setVariantCount(Number variantCount) {
        this.variantCount = variantCount;
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

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }

    public String[] getVariants() {
        return variants;
    }

    public void setVariants(String[] variants) {
        this.variants = variants;
    }

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    public String[] getPrice() {
        return price;
    }

    public void setPrice(String[] price) {
        this.price = price;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }
}
