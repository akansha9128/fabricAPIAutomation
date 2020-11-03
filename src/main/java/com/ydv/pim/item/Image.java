package com.ydv.pim.item;

public class Image {
    private String _id;
    private String label;
    private Number order;
    private String id;
    private Source[] source;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Number getOrder() {
        return order;
    }

    public void setOrder(Number order) {
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Source[] getSource() {
        return source;
    }

    public void setSource(Source[] source) {
        this.source = source;
    }
}
