package com.ydv.offer;

public class Offers {

    private String kind;
    private Number channel;
    private String startDate;
    private String endDate;
    private Prices price;
    private String _id;
    private Number offerCode;
    private String id;




    public Number getChannel() {
        return channel;
    }

    public void setChannel(Number channel) {
        this.channel = channel;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Prices getPrice() {
        return price;
    }

    public void setPrice(Prices price) {
        this.price = price;
    }

    public Number getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(Number offerCode) {
        this.offerCode = offerCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
