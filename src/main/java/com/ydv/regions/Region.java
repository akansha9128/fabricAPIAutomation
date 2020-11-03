package com.ydv.regions;

public class Region {

    private String name;
    private String regionCode;
    private String currencyCode;
    private String parent;
    private RegionKind kind;


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setKind(RegionKind kind) {
        this.kind =  kind;
    }
    public RegionKind getKind() {
        return this.kind;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
/*public String getTypeOfKind() {
        return typeOfKind;
    }

    public void setTypeOfKind(String typeOfKind, RegionKind kind) {
        this.typeOfKind = typeOfKind;
        this.kind = kind;
    }*/