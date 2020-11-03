package com.ydv.xpmGlobalComponents;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {

    private String text;
    private String link;
    @JsonProperty
    private boolean external;



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }
}
