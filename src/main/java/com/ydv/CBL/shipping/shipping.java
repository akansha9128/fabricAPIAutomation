package com.ydv.CBL.shipping;

import java.util.Date;

public class shipping {

    private String name;
    private String _id;
    private String description;
    private String taxCode;
    private int minimumDays;
    private int maximumDays;
    private int cutOffTime;
    private Number cost;
    private int[] channel;
    private String[] addressType;
    private String createdBy;
    private int shippingMethodId;
    private int shipMethodId;
    private String message;
    private String code;
    private int statusCode;
    private String updatedBy;
    private Date createdAt;
    private Date updatedAt;
    private int __v;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public int getMinimumDays() {
        return minimumDays;
    }

    public void setMinimumDays(int minimumDays) {
        this.minimumDays = minimumDays;
    }

    public int getMaximumDays() {
        return maximumDays;
    }

    public void setMaximumDays(int maximumDays) {
        this.maximumDays = maximumDays;
    }

    public int getCutOffTime() {
        return cutOffTime;
    }

    public void setCutOffTime(int cutOffTime) {
        this.cutOffTime = cutOffTime;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int[] getChannel() {
        return channel;
    }

    public void setChannel(int[] channel) {
        this.channel = channel;
    }

    public String[] getAddressType() {
        return addressType;
    }

    public void setAddressType(String[] addressType) {
        this.addressType = addressType;
    }

    public int getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(int shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public Number getCost() {
        return cost;
    }

    public void setCost(Number cost) {
        this.cost = cost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getShipMethodId() {
        return shipMethodId;
    }

    public void setShipMethodId(int shipMethodId) {
        this.shipMethodId = shipMethodId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
