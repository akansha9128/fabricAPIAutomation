package com.ydv.identity.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ydv.BaseFields;

import java.util.Map;

public class Role extends BaseFields {

    private String extraKind;
    private String extra;
    private String kind;



    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }


    public String getExtraKind() {
        return extraKind;
    }

    public void setExtraKind(String extraKind) {
        this.extraKind = extraKind;
    }
}
