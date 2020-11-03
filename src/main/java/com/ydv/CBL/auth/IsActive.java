package com.ydv.CBL.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IsActive {


    @JsonProperty
    private boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
