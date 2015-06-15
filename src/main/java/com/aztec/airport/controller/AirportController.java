package com.aztec.airport.controller;

import com.aztec.airport.dto.AirportDto;
import com.aztec.airport.helper.AirportHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Controller for the Airports.
 *
 * @author robertgolder
 */
@RestController
@RequestMapping(value="/airport")
public class AirportController {

    @Value("${aztec.airport.url.base}")
    private String baseUrl;

    @Value("${aztec.airport.url}")
    private String airportUrl;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView list() {
        List<AirportDto> airports = AirportHelper.list();
        return new ModelAndView("airport-list", "airports", airports);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{code}")
    public ModelAndView retrieve(@PathVariable("code") int code) {
        AirportDto airport = AirportHelper.retrieve(code);
        return new ModelAndView("airport-view", "airport", airport);
    }
}
