package com.ydv.identity.permission;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ydv.BaseFields;

import java.util.Map;

public class Permission extends BaseFields {

    private String limit;
    private String offset;
    private String count;
    private String updatedAt;


    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}


