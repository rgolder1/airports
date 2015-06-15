package com.aztec.airport.dto;

/**
 * @author robertgolder
 */
public class AddressDto {

    private String addressLine1 = "line 1";
    private String addressLine2 = "line 2";
    private String postTown = "town";
    private String postCode = "SW1A 1AA";

    public AddressDto(){}

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostTown() {
        return postTown;
    }

    public void setPostTown(String postTown) {
        this.postTown = postTown;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
