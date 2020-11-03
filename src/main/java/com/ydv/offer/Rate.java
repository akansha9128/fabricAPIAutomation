package com.ydv.offer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rate  {
        private Offers[] offers;

        private Number[] itemIds;

        private String createdAt;

        private Number offerId;

        private String _id;

        @JsonProperty
        private boolean isSoftDeleted;

        private Number itemId;

        private String updatedAt;

        private Number __v;



    public boolean getIsSoftDeleted() {
        return isSoftDeleted;
    }

    public void setSoftDeleted(boolean isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }


        public Offers[] getOffers ()
        {
            return offers;
        }

        public void setOffers (Offers[] offers)
        {
            this.offers = offers;
        }


        public String getCreatedAt ()
        {
            return createdAt;
        }

        public void setCreatedAt (String createdAt)
        {
            this.createdAt = createdAt;
        }


        public String get_id ()
        {
            return _id;
        }

        public void set_id (String _id)
        {
            this._id = _id;
        }


        public String getUpdatedAt ()
        {
            return updatedAt;
        }

        public void setUpdatedAt (String updatedAt)
        {
            this.updatedAt = updatedAt;
        }


    public Number getItemId() {
        return itemId;
    }

    public void setItemId(Number itemId) {
        this.itemId = itemId;
    }

    public Number[] getItemIds() {
        return itemIds;
    }

    public void setItemIds(Number[] itemIds) {
        this.itemIds = itemIds;
    }

    public Number getOfferId() {
        return offerId;
    }

    public void setOfferId(Number offerId) {
        this.offerId = offerId;
    }

    public Number get__v() {
        return __v;
    }

    public void set__v(Number __v) {
        this.__v = __v;
    }
}
