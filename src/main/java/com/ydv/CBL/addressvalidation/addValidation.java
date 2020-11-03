package com.ydv.CBL.addressvalidation;


import java.io.Serializable;

public class addValidation implements Serializable {


    private String addressValid;
    private validatedAddrSuggestions[] validatedAddrSuggestions;
    private int addressesFound;


    public int getAddressesFound() {
        return addressesFound;
    }

    public void setAddressesFound(int addressesFound) {
        this.addressesFound = addressesFound;
    }

    public validatedAddrSuggestions[] getValidatedAddrSuggestions() {
        return validatedAddrSuggestions;
    }

    public void setValidatedAddrSuggestions(validatedAddrSuggestions[] validatedAddrSuggestions) {
        this.validatedAddrSuggestions = validatedAddrSuggestions;
    }


    public String getAddressValid() {
        return addressValid;
    }

    public void setAddressValid(String addressValid) {
        this.addressValid = addressValid;
    }
}

