package com.aztec.airport.controller;

import com.aztec.airport.dto.AeroplaneDto;
import com.aztec.airport.dto.AirportDto;
import com.aztec.airport.helper.AeroplaneHelper;
import com.aztec.airport.helper.AirportHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller for the Aeroplanes.
 *
 * @author robertgolder
 */
@RestController
@RequestMapping(value="/aeroplane")
public class AeroplaneController {

    @Value("${aztec.aeroplane.url.base}")
    private String baseUrl;

    @Value("${aztec.aeroplane.url}")
    private String aeroplaneUrl;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "/list/{airportCode}")
    public ModelAndView list(@PathVariable("airportCode") String airportCode) {
        List<AeroplaneDto> aeroplanes = AeroplaneHelper.list(airportCode);
        return new ModelAndView("aeroplane-list", "aeroplanes", aeroplanes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{aeroplaneCode}")
    public ModelAndView retrieve(@PathVariable("aeroplaneCode") String aeroplaneCode) {
        AeroplaneDto aeroplane = AeroplaneHelper.retrieve(aeroplaneCode);
        return new ModelAndView("aeroplane-view", "aeroplane", aeroplane);
    }
}