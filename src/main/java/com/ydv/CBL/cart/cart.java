package com.ydv.CBL.cart;

public class cart {

    private Number id;
    private Number cartId;
    private items[] items;
    private String createdAt;
    private String updatedAt;
    private Number __v;
    private Number totalAmount;
    private Number quantity;


    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public Number getCartId() {
        return cartId;
    }

    public void setCartId(Number cartId) {
        this.cartId = cartId;
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

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public com.ydv.CBL.cart.items[] getItems() {
        return items;
    }

    public void setItems(com.ydv.CBL.cart.items[] items) {
        this.items = items;
    }

    public Number get__v() {
        return __v;
    }

    public void set__v(Number __v) {
        this.__v = __v;
    }

    public Number getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Number totalAmount) {
        this.totalAmount = totalAmount;
    }
}
