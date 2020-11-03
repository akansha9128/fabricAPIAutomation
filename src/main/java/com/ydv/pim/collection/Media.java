package com.ydv.pim.collection;

public class Media {

    private int order;

    private String label;

    private Source[] source;

    private String _id;

    public void setOrder(int order){
        this.order = order;
    }
    public int getOrder(){
        return this.order;
    }
    public void setLabel(String label){
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }
    public void setSource(Source[] source){
        this.source = source;
    }
    public Source[] getSource(){
        return this.source;
    }
    public void set_id(String _id){
        this._id = _id;
    }
    public String get_id(){
        return this._id;
    }

}
