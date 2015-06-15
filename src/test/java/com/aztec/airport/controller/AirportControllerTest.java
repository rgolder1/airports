package com.aztec.airport.controller;

import com.aztec.airport.application.Application;
import com.aztec.airport.dto.AirportDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Controller test.
 *
 * @author robertgolder
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes={Application.class})
public class AirportControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testList() throws Exception {

        ResultActions result = mockMvc.perform(get("/airport/list")
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(view().name("airport-list"))
                .andExpect(model().attributeExists("airports"));

        List<AirportDto> airports = (List<AirportDto>)result.andReturn().getModelAndView().getModelMap().get("airports");
        assertThat(airports.size(), is(3));
    }

    @Test
    public void testRetrieve() throws Exception {

        ResultActions result = mockMvc.perform(get("/airport/2")
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(view().name("airport-view"))
                .andExpect(model().attributeExists("airport"));

        AirportDto airport = (AirportDto)result.andReturn().getModelAndView().getModelMap().get("airport");
        assertThat(airport, notNullValue());
        assertThat(airport.getName(), is("Heathrow"));
    }
}
