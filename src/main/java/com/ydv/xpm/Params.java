package com.ydv.xpm;

import com.ydv.xpmGlobalComponents.FooterLinks;

public class Params {

    private FooterLinks[] footerLinks;
    private Components.Links[] links;
    private String kind;
	private String value;
    


    public FooterLinks[] getFooterLinks() {
        return footerLinks;
    }

    public void setFooterLinks(FooterLinks[] footerLinks) {
        this.footerLinks = footerLinks;
    }

    public Components.Links[] getLinks() {
        return links;
    }

    public void setLinks(Components.Links[] links) {
        this.links = links;
    }

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
