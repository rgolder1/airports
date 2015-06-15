package com.aztec.airport.helper;

import com.aztec.airport.dto.AeroplaneDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Aeroplane helper class.
 *
 * @author robertgolder
 */
@RestController
public class AeroplaneHelper {

    private static final AeroplaneDto aeroplane1 = new AeroplaneDto("Aeroplane1", "111abc", "AB12 ABC");
    private static final AeroplaneDto aeroplane2 = new AeroplaneDto("Aeroplane2", "111abc", "CD12 ABC");
    private static final AeroplaneDto aeroplane3 = new AeroplaneDto("Aeroplane3", "111def", "EF12 ABC");
    private static final AeroplaneDto aeroplane4 = new AeroplaneDto("Aeroplane4", "111def", "GH12 ABC");
    private static final AeroplaneDto aeroplane5 = new AeroplaneDto("Aeroplane5", "222abc", "IJ12 ABC");
    private static final AeroplaneDto aeroplane6 = new AeroplaneDto("Aeroplane6", "222abc", "KL12 ABC");
    private static final AeroplaneDto aeroplane7 = new AeroplaneDto("Aeroplane7", "222def", "MN12 ABC");
    private static final AeroplaneDto aeroplane8 = new AeroplaneDto("Aeroplane8", "222def", "OP12 ABC");
    private static final AeroplaneDto aeroplane9 = new AeroplaneDto("Aeroplane9", "333abc", "QR12 ABC");
    private static final AeroplaneDto aeroplane10 = new AeroplaneDto("Aeroplane10", "333abc", "ST12 ABC");
    private static final AeroplaneDto aeroplane11 = new AeroplaneDto("Aeroplane11", "333def", "UV12 ABC");
    private static final AeroplaneDto aeroplane12 = new AeroplaneDto("Aeroplane12", "333def", "WX12 ABC");

    public static List<AeroplaneDto> list(@PathVariable("airportCode") String airportCode) {
        List<AeroplaneDto> aeroplanes = new ArrayList<>();

        switch (airportCode) {

            case "111abc":
                aeroplanes.add(aeroplane1);
                aeroplanes.add(aeroplane2);
                break;

            case "111def":
                aeroplanes.add(aeroplane3);
                aeroplanes.add(aeroplane4);
                break;

            case "222abc":
                aeroplanes.add(aeroplane5);
                aeroplanes.add(aeroplane6);
                break;

            case "222def":
                aeroplanes.add(aeroplane7);
                aeroplanes.add(aeroplane8);
                break;

            case "333abc":
                aeroplanes.add(aeroplane9);
                aeroplanes.add(aeroplane10);
                break;

            case "333def":
                aeroplanes.add(aeroplane11);
                aeroplanes.add(aeroplane12);
                break;

            default:
                break;
        }

        return aeroplanes;
    }

    public static AeroplaneDto retrieve(@PathVariable("code") String code) {

        AeroplaneDto aeroplane = null;

        switch (code) {

            case "AB12 ABC":
                aeroplane = aeroplane1;
                break;
            case "CD12 ABC":
                aeroplane = aeroplane2;
                break;
            case "EF12 ABC":
                aeroplane = aeroplane3;
                break;
            case "GH12 ABC":
                aeroplane = aeroplane4;
                break;
            case "IJ12 ABC":
                aeroplane = aeroplane5;
                break;
            case "KL12 ABC":
                aeroplane = aeroplane6;
                break;
            case "MN12 ABC":
                aeroplane = aeroplane7;
                break;
            case "OP12 ABC":
                aeroplane = aeroplane8;
                break;
            case "QR12 ABC":
                aeroplane = aeroplane9;
                break;
            case "ST12 ABC":
                aeroplane = aeroplane10;
                break;
            case "UV12 ABC":
                aeroplane = aeroplane11;
                break;
            case "WX12 ABC":
                aeroplane = aeroplane12;
                break;
        }
        return aeroplane;
    }
}
