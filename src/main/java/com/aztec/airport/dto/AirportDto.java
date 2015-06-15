package com.aztec.airport.dto;

import java.util.List;

/**
 * @author robertgolder
 */
public class AirportDto {

    private final String name;
    private final Integer code;
    private AddressDto address = new AddressDto();
    private String status;
    private List<String> aeroplaneCodes;

    public AirportDto(String name, Integer code, List<String> aeroplaneCodes, String status) {
        this.name = name;
        this.code = code;
        this.aeroplaneCodes = aeroplaneCodes;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAeroplaneCodes() {
        return aeroplaneCodes;
    }

    public void setAeroplaneCodes(List<String> aeroplaneCodes) {
        this.aeroplaneCodes = aeroplaneCodes;
    }
}
