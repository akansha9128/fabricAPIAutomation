package com.ydv.CBL.tax;

public class lines {
    private Number lineAmount;
    private String taxCode;
    private String description;
    private Number id;
    private Number lineNumber;
    private Number tax;
    private Number taxableAmount;
    private Number taxCalculated;
    private Number quantity;
    private boolean isItemTaxable;

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isItemTaxable() {
        return isItemTaxable;
    }

    public void setItemTaxable(boolean itemTaxable) {
        isItemTaxable = itemTaxable;
    }

    public Number getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(Number taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public Number getTaxCalculated() {
        return taxCalculated;
    }

    public void setTaxCalculated(Number taxCalculated) {
        this.taxCalculated = taxCalculated;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Number getTax() {
        return tax;
    }

    public Number getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(Number lineAmount) {
        this.lineAmount = lineAmount;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public void setTax(Number tax) {
        this.tax = tax;
    }

    public Number getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Number lineNumber) {
        this.lineNumber = lineNumber;
    }
}
