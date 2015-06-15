package com.aztec.airport.helper;

import com.aztec.airport.dto.AirportDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Helper class.
 *
 * @author robertgolder
 */
@RestController
public class AirportHelper {

    private static final AirportDto airport1 = new AirportDto("Gatwick", 1, Arrays.asList("111abc","111def"), "OPEN");
    private static final AirportDto airport2 = new AirportDto("Heathrow", 2, Arrays.asList("222abc","222def"), "OPEN");
    private static final AirportDto airport3 = new AirportDto("Stanstead", 3, Arrays.asList("333abc","333def"), "CLOSED");

    public static List<AirportDto> list() {
        List<AirportDto> airports = new ArrayList<>();
        airports.add(airport1);
        airports.add(airport2);
        airports.add(airport3);
        return airports;
    }

    public static AirportDto retrieve(@PathVariable("code") Integer code) {

        AirportDto airport = null;

        switch (code) {

            case 1:
                airport = airport1;
                break;
            case 2:
                airport = airport2;
                break;
            case 3:
                airport = airport3;
                break;
        }
        return airport;
    }
}
