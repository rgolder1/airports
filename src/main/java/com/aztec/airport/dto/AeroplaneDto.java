package com.aztec.airport.dto;

/**
 * @author robertgolder
 */
public class AeroplaneDto {

    private final String name;
    private final String airportCode;
    private final String aeroplaneCode;

    public AeroplaneDto(final String name, final String airportCode, final String aeroplaneCode) {
        this.name = name;
        this.airportCode = airportCode;
        this.aeroplaneCode = aeroplaneCode;
    }

    public String getName() {
        return name;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public String getAeroplaneCode() {
        return aeroplaneCode;
    }
}
