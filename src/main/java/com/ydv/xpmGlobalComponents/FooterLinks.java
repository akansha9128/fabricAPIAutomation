package com.ydv.xpmGlobalComponents;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FooterLinks {

    private String title;
    private String url;
    @JsonProperty
    private boolean external;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }
}
