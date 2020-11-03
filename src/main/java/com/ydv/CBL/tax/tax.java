package com.ydv.CBL.tax;


import java.util.Date;

public class tax {

    private lines[] lines;
    private String type;
    private Date date;
    private String companyCode;
    private String customerCode;
    private boolean commit;
    private String addresses;
    private String shipTo;
    private String line1;
    private String city;
    private String region;
    private String country;
    private String postalCode;
    private String shipFrom;
    private String code;
    private String status;
    private Number totalAmount;
    private Number totalExempt;
    private Number totalDiscount;
    private Number totalTax;
    private Number totalTaxable;
    private Number totalTaxCalculated;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }


    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getShipFrom() {
        return shipFrom;
    }

    public void setShipFrom(String shipFrom) {
        this.shipFrom = shipFrom;
    }

    public boolean isCommit() {
        return commit;
    }

    public void setCommit(boolean commit) {
        this.commit = commit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }





    public void setCode(String code) {
        this.code = code;
    }

    public Number getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Number totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Number getTotalExempt() {
        return totalExempt;
    }

    public void setTotalExempt(Number totalExempt) {
        this.totalExempt = totalExempt;
    }

    public Number getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Number totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Number getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Number totalTax) {
        this.totalTax = totalTax;
    }

    public Number getTotalTaxable() {
        return totalTaxable;
    }

    public void setTotalTaxable(Number totalTaxable) {
        this.totalTaxable = totalTaxable;
    }

    public Number getTotalTaxCalculated() {
        return totalTaxCalculated;
    }

    public void setTotalTaxCalculated(Number totalTaxCalculated) {
        this.totalTaxCalculated = totalTaxCalculated;
    }

    public com.ydv.CBL.tax.lines[] getLines() {
        return lines;
    }

    public void setLines(com.ydv.CBL.tax.lines[] lines) {
        this.lines = lines;
    }
}
